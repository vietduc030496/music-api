package com.music.MP3.co.utils;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtils {

    public final String DDMMYYYY_FLASH = "dd-MM-yyyy";

    public final String HHMM_DDMMYYYY_FLASH = "hh:mm dd-MM-yyyy";

    public String format(Date date) {
        return format(date, HHMM_DDMMYYYY_FLASH);
    }

    public String format(Date date, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
