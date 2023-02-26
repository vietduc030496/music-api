package com.music.MP3.co.utils;

import com.music.MP3.co.controller.config.i18n.MessageComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nUtils {

    private static MessageComponent messageComponent;

    private static Locale defaultLocale = Locale.US;

    @Autowired
    public I18nUtils(MessageComponent injectMessage) {
        messageComponent = injectMessage;
    }

    public static String get(String code) {
        return get(code, defaultLocale);
    }
    public static String get(String code, Object... params) {
        return get(code, defaultLocale, params);
    }

    public static String get(String code, Locale locale, Object... params) {
        return messageComponent.getMessage(code, locale, params);
    }

}
