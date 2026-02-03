package com.kikiriki.domain;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Answer {

    private String id;
    private String text;
    private boolean correct;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
