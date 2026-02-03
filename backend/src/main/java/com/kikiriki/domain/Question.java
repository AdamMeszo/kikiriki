package com.kikiriki.domain;

import java.util.ArrayList;
import java.util.List;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public sealed class Question permits PictureQuestion, SimpleQuestion {

    private String id;
    private String question;
    private List<String> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAnswers() {
        if (this.answers == null) {
            this.answers = new ArrayList<>();
        }
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
