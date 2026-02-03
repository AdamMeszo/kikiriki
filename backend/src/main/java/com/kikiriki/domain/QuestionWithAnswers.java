package com.kikiriki.domain;

import java.util.Map;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Serdeable
public record QuestionWithAnswers(@NotEmpty String questionId, @NotEmpty String question, @NotNull Map<String, String> answers) {

}
