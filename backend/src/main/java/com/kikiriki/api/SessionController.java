package com.kikiriki.api;

import java.util.UUID;

import com.kikiriki.db.TmpStorage;
import com.kikiriki.domain.Session;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.validation.constraints.NotEmpty;

@Controller("/session")
public class SessionController {

    private final TmpStorage tmpStorage;

    public SessionController(TmpStorage tmpStorage) {
        this.tmpStorage = tmpStorage;
    }

    @Post
    public String createSession(@QueryValue @NotEmpty String adminId, @QueryValue @NotEmpty String name) {
        var sessionId = UUID.randomUUID().toString();
        var session = new Session(sessionId, tmpStorage.getAdmin(), name);
        tmpStorage.setSession(session);
        return sessionId;
    }

    @Get
    public void loadSession(String sessionId) {

    }
}
