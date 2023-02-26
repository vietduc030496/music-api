package com.music.MP3.co.service;

import com.music.MP3.co.constant.CommonConstants;
import com.music.MP3.co.constant.MessageConstants;
import com.music.MP3.co.domain.dto.response.BaseResponse;
import com.music.MP3.co.domain.dto.response.NoDataResponse;
import com.music.MP3.co.domain.model.User;
import com.music.MP3.co.repository.UserRepositories;
import com.music.MP3.co.utils.I18nUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BaseResponse update(long userId, Map<String, Object> attribute) {

        Optional<User> optionalUser = userRepositories.findById(userId);

        if (optionalUser.isEmpty()) {
            return new NoDataResponse(CommonConstants.HTTP_BAD_REQUEST_CODE, I18nUtils.get(MessageConstants.ERR0001));
        }
        User user = optionalUser.get();

        attribute.forEach((key, value) -> {
            String fieldName = getFieldName(key);
            Field field = ReflectionUtils.findField(User.class, fieldName);
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            if (field.getName().equals("password")) {
                value = passwordEncoder.encode((String) value);
            }
            ReflectionUtils.setField(field, user, value);
        });

        userRepositories.saveAndFlush(user);

        return new NoDataResponse(I18nUtils.get(MessageConstants.MES0003));
    }

    private String getFieldName(String jsonField) {
        if (!StringUtils.contains(jsonField, "_")) {
            return jsonField;
        }

        int indexOfUnderline = StringUtils.indexOf(jsonField, "_");
        String temp = String.valueOf(jsonField.charAt(indexOfUnderline + 1));
        String fieldName = StringUtils.replaceChars(jsonField, temp, temp.toLowerCase());
        fieldName = StringUtils.replace(fieldName, "_", "");
        return fieldName;
    }
}
