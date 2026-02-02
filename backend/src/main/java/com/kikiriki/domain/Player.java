package com.kikiriki.domain;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public class Player {
    @Id 
    private String id;
    @NotNull
    private String name;
    private Map<String, Answer> answers;

    public Player(String playerId, String name) {
        this.id = playerId;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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