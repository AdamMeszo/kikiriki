package com.kikiriki.api;

import java.util.List;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/answer")
public class AnswerController {
    @Post
    public void saveAnswer(String sessionId, String questionId, List<String> answerList) {
        
    }
}
