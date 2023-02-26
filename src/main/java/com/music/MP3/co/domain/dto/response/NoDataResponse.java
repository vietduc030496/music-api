package com.music.MP3.co.domain.dto.response;


public class NoDataResponse extends BaseResponse {

    public NoDataResponse(String message) {
        super(message);
    }

    public NoDataResponse(int code, String message) {
        super(code, message);
    }
}
