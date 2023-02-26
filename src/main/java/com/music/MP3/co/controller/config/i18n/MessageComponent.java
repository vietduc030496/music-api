package com.music.MP3.co.controller.config.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageComponent {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code, Locale locale, Object... params) {
        String message = messageSource.getMessage(code, params, locale);
        return StringUtils.defaultString(message);
    }
}
