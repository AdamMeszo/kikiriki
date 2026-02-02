package com.kikiriki.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public record Player(@Id String id, @NotNull String login, @NotNull String password) {
    
}