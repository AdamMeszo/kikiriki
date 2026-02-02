package com.kikiriki.api;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/")
public class UserController {
    @Post(uri = "admin")
    public void createAdmin() {

    }

    @Post(uri = "player")
    public void createPlayer(String sessionId) {

    }
}
