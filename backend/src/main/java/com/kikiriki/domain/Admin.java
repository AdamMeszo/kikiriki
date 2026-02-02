package com.kikiriki.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public record Admin(@Id String id, @NotNull Session session, @NotEmpty String login, @NotEmpty String password) {
    
}
