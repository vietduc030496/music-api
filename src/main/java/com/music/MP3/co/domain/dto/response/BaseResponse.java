package com.music.MP3.co.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.music.MP3.co.constant.CommonConstants;
import lombok.Data;

@Data
public class BaseResponse {

    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("message")
    private String message;

    public BaseResponse(String message) {
        this.statusCode = CommonConstants.HTTP_SUCCESS_CODE;
        this.message = message;
    }
    public BaseResponse(int code, String message) {
        this.statusCode = code;
        this.message = message;
    }
}
