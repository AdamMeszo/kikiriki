package com.kikiriki.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public class Session {
    @Id 
    private String id;
    @NotNull 
    private Admin admin; 
    private SortedMap<Integer, Question> questions;
    private List<Player> players;
    @NotEmpty 
    private String name;

    public Session(String id, Admin admin, String name) {
        this.id = id;
        this.admin = admin;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public SortedMap<Integer, Question> getQuestions() {
        if (this.questions == null) {
            this.questions = new TreeMap<Integer, Question>();
        }
        return questions;
    }
    public void setQuestions(SortedMap<Integer, Question> questions) {
        this.questions = questions;
    }
    public List<Player> getPlayers() {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}