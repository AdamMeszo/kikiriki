package com.kikiriki.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotEmpty;

@MappedEntity
public record Admin(@Id String id, @NotEmpty String login, @NotEmpty String password) {
    
}
