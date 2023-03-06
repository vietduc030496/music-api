package com.music.MP3.co.utils;

import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtils {

    public final String DDMMYYYY_FLASH = "dd-MM-yyyy";

    public final String HHMM_DDMMYYYY_FLASH = "hh:mm dd-MM-yyyy";

    /**
     * Format date with default format, value of default format is {@code 'hh:mm dd-MM-yyyy'}
     * 
     * @param date object date need format(must not null)
     * @return String String date after format(not null)
     * @see SimpleDateFormat#format(Date)
     * @see DateUtils#format(Date, String) 
     */
    public String format(Date date) {
        return format(date, HHMM_DDMMYYYY_FLASH);
    }

    /**
     * Format date to string with pattern.
     * Ex: {@code pattern = "dd-MM-yyyy"} then return {@code 03-04-2023}
     *
     * @param date object date need format (must not null)
     * @param pattern pattern format to use format date to string (must not null)
     * @return String String date after format(not null)
     * @see SimpleDateFormat#format(Date) 
     */
    public String format(@NotNull Date date, @NotNull String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
