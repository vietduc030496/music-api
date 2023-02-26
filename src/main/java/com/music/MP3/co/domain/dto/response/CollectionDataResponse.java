package com.music.MP3.co.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;


public class CollectionDataResponse<T> extends BaseResponse {

    @JsonProperty("results")
    private Collection<T> results;

    public CollectionDataResponse(String message) {
        super(message);
    }

    public CollectionDataResponse(int code, String message) {
        super(code, message);
    }
}
