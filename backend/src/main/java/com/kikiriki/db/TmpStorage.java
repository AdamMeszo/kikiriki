package com.kikiriki.db;

import com.kikiriki.domain.Admin;
import com.kikiriki.domain.Session;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CachePut;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;

@Singleton
@CacheConfig("sessions")
public class TmpStorage {

    private Admin admin;
    private Session session;

    @Cacheable
    public Admin getAdmin() {
        return admin;
    }

    @CachePut(parameters = {"admin"})
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Cacheable
    public Session getSession() {
        return session;
    }

    @CachePut(parameters = {"session"})
    public void setSession(Session session) {
        this.session = session;
    }
}
