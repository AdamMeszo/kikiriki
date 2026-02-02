package com.kikiriki.api;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/session")
public class SessionController {
    @Post
    public void createSession(String adminId) {

    }

    @Get
    public void loadSession(String sessionId) {

    }
}
