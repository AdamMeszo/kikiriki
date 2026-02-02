package com.kikiriki.domain;

import java.util.HashMap;
import java.util.Map;

public sealed class Question permits PictureQuestion, SimpleQuestion {
    private String id;
    private String question;
    private Map<String, Answer> answers;

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
    public Map<String, Answer> getAnswers() {
        if (this.answers == null) {
            this.answers = new HashMap<>();
        }
        return answers;
    }
    public void setAnswers(Map<String, Answer> answers) {
        this.answers = answers;
    }
}
