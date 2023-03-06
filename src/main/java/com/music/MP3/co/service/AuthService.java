package com.music.MP3.co.service;

import com.music.MP3.co.config.security.jwt.JwtProvider;
import com.music.MP3.co.constant.CommonConstants;
import com.music.MP3.co.constant.MessageConstants;
import com.music.MP3.co.domain.dto.request.login.LoginRequest;
import com.music.MP3.co.domain.dto.request.login.SignupRequest;
import com.music.MP3.co.domain.dto.response.BaseResponse;
import com.music.MP3.co.domain.dto.response.DataResponse;
import com.music.MP3.co.domain.dto.response.NoDataResponse;
import com.music.MP3.co.domain.model.User;
import com.music.MP3.co.repository.UserRepositories;
import com.music.MP3.co.utils.I18nUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Login system
     *
     * @param request include username and password of user
     * @return result and message of result login. If username or password incorrect then login failed.
     */
    public BaseResponse login(LoginRequest request) {

        User userLogin = userRepositories.findByUsername(request.getUsername());

        if (userLogin == null) {

            return new NoDataResponse(CommonConstants.HTTP_BAD_REQUEST_CODE, I18nUtils.get(MessageConstants.ERR0001));
        }

        String rawPassword = request.getPassword();

        if (passwordEncoder.matches(rawPassword, userLogin.getPassword())) {

            DataResponse<String> response = new DataResponse<>(I18nUtils.get(MessageConstants.MES0001));
            response.setResult(jwtProvider.generateToken(request.getUsername()));

            return response;
        }

        return new NoDataResponse(CommonConstants.HTTP_BAD_REQUEST_CODE, I18nUtils.get(MessageConstants.ERR0002));
    }

    /**
     * Sign in new account for new user
     *
     * @param request include new username, password and confirm password of new user.
     * @return result and message of result signup.
     *         If username is existed or password not equal confirm password then registration failed
     */
    public BaseResponse signup(SignupRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();

        boolean hasExists = userRepositories.existsByUsername(username);

        if (hasExists) {
            return new NoDataResponse(CommonConstants.HTTP_BAD_REQUEST_CODE, I18nUtils.get(MessageConstants.ERR0003));
        }

        if (!StringUtils.equals(password, confirmPassword)) {
            return new NoDataResponse(CommonConstants.HTTP_BAD_REQUEST_CODE, I18nUtils.get(MessageConstants.ERR0004));
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepositories.saveAndFlush(newUser);

        return new NoDataResponse(CommonConstants.HTTP_CREATED_CODE, I18nUtils.get(MessageConstants.MES0002));
    }

}
