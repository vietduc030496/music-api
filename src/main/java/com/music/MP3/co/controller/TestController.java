package com.music.MP3.co.controller;

import com.music.MP3.co.utils.I18nUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {


    @GetMapping
    public String test() {
        String mes01 = I18nUtils.get("MES01");
        String mes02 = I18nUtils.get("MES02");
        return mes01 + mes02;
    }

}
