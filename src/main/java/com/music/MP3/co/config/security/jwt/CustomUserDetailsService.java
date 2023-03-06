package com.music.MP3.co.config.security.jwt;

import com.music.MP3.co.domain.model.User;
import com.music.MP3.co.repository.UserRepositories;
import com.music.MP3.co.utils.I18nUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepositories.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(I18nUtils.get("ERR0001"));
        }

        return CustomUserDetails.getUserInfo(user);
    }
}
