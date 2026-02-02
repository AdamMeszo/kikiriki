package com.kikiriki.api;

import java.util.List;
import java.util.Optional;

import com.kikiriki.db.TmpStorage;
import com.kikiriki.domain.Answer;
import com.kikiriki.domain.Question;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Controller("/answer")
public class AnswerController {

    private final TmpStorage tmpStorage;

    public AnswerController(TmpStorage tmpStorage) {
        this.tmpStorage = tmpStorage;
    }

    @Post(value = "/session/{sessionId}/user/{userId}/question/{questionId}")
    public boolean saveAnswer(@NotEmpty String sessionId, @NotEmpty String userId, @NotEmpty String questionId, @Body @NotNull List<String> userAnswers) {
        var session = tmpStorage.getSession();

        if (session == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Something went wrong...");
        }

        if (!sessionId.equals(session.getId())) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Something went wrong...");
        }

        if (session.getPlayers().stream().anyMatch(player -> player.getId().equals(userId))) {

            Optional<Question> questionOptional = session.getQuestions().values().stream().filter(question -> questionId.equals(question.getId())).findFirst();
            if (questionOptional.isPresent()) {
                var question = questionOptional.get();
                int correct = 0;
                int guessed = 0;
                for (Answer answer : question.getAnswers().values()) {
                    if (answer.isCorrect()) {
                        correct++;
                        if (userAnswers.stream().anyMatch(userAnswer -> userAnswer.equals(answer.getText()))) {
                            guessed++;
                        }
                    }
                }
                return correct == guessed;
            }
        }

        throw new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...");
    }
}
