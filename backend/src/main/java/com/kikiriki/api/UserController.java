package com.kikiriki.api;

import java.util.UUID;

import com.kikiriki.db.TmpStorage;
import com.kikiriki.domain.Admin;
import com.kikiriki.domain.Player;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.validation.constraints.NotEmpty;

@Controller("/user")
public class UserController {

    private final TmpStorage tmpStorage;

    public UserController(TmpStorage tmpStorage) {
        this.tmpStorage = tmpStorage;
    }

    @Post(value = "/admin")
    public String createAdmin(@QueryValue String login, @QueryValue String password) {
        var admin = new Admin(UUID.randomUUID().toString(), login, password);
        tmpStorage.setAdmin(admin);
        return admin.id();
    }

    @Post(value = "/player")
    public String createPlayer(@QueryValue @NotEmpty String sessionId, @QueryValue @NotEmpty String name) {
        var session = tmpStorage.getSession();
        if (sessionId.equals(session.getId())) {
            throw new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong...");
        }
        var playerId = UUID.randomUUID().toString();
        var player = new Player(playerId, name);
        session.getPlayers().add(player);
        return playerId;
    }
}
