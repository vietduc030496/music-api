package com.music.MP3.co.config.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageComponent {

    /**
     * Initialize message source
     *
     * @see LocaleConfig#messageSource()
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Get message have code in locale and insert params
     *
     * @param code
     * @param locale
     * @param params
     * @return message, if message not exits then return empty.
     */
    public String getMessage(String code, Locale locale, Object... params) {
        String message = messageSource.getMessage(code, params, locale);
        return StringUtils.defaultString(message);
    }
}
