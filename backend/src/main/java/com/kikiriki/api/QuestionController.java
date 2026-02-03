package com.kikiriki.api;

import java.util.HashMap;
import java.util.UUID;

import com.kikiriki.db.TmpStorage;
import com.kikiriki.domain.Answer;
import com.kikiriki.domain.Question;
import com.kikiriki.domain.QuestionWithAnswers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Controller("/question")
public class QuestionController {

    private final TmpStorage tmpStorage;

    public QuestionController(TmpStorage tmpStorage) {
        this.tmpStorage = tmpStorage;
    }

    @Post(value = "/session/{sessionId}")
    public void saveQuestion(@NotEmpty String sessionId, @Body @NotNull Question question) {
        var questionId = UUID.randomUUID().toString();
        question.setId(questionId);
        var session = tmpStorage.getSession();
        if (session == null) {
            throw new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...");
        }
        var storedSessionId = session.getId();
        if (!sessionId.equals(storedSessionId)) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Wrong request");
        }
        var index = 1;
        if (!session.getQuestions().isEmpty()) {
            index = session.getQuestions().lastKey() + 1;
        }
        tmpStorage.getSession().getQuestions().put(index, question);
    }

    @Get(value = "/session/{sessionId}/index/{index}")
    public QuestionWithAnswers loadQuestion(@NotEmpty String sessionId, @NotNull Integer index) {
        var session = tmpStorage.getSession();
        var storedSessionId = session.getId();

        if (!sessionId.equals(storedSessionId)) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Wrong request");
        }

        var question = session.getQuestions().get(index);
        var questionText = question.getQuestion();

        var answers = new HashMap<String, String>();

        for (Answer answer : session.getAnswers()) {
            if (question.getAnswers().contains(answer.getId())) {
                answers.put(answer.getId(), answer.getText());
            }
        }
        
        return new QuestionWithAnswers(question.getId(), questionText, answers);
    }

    @Get(uri = "/results")
    public void loadQuestionResults(String sessionId, String questionId) {
        throw new HttpStatusException(HttpStatus.NOT_IMPLEMENTED, "Something went wrong...");
    }
}
