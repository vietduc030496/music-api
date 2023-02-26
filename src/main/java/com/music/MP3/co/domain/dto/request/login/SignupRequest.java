package com.music.MP3.co.domain.dto.request.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SignupRequest {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("confirm_password")
    private String confirmPassword;
}
