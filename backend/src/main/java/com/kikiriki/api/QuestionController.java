package com.kikiriki.api;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/question")
public class QuestionController {
    @Get
    public void loadQuestion(String sessionId, String questionId) {

    }

    @Get(uri = "/results")
    public void loadQuestionResults(String sessionId, String questionId) {
        
    }
}
