package com.kikiriki.domain;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public non-sealed class PictureQuestion extends Question {
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }
}
