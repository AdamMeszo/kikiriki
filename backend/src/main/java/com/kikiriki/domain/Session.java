package com.kikiriki.domain;

import java.util.List;
import java.util.Queue;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public record Session(@Id String id, @NotNull Admin admin, Queue<Question> questions, List<Player> players) {

}