package com.music.MP3.co.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class DataResponse<T> extends BaseResponse {

    @JsonProperty("result")
    private T result;

    public DataResponse(String message) {
        super(message);
    }

    public DataResponse(int code, String message) {
        super(code, message);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
