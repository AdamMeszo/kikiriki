package com.kikiriki.db;

import com.kikiriki.domain.Admin;
import com.kikiriki.domain.Session;

import io.micronaut.context.annotation.Bean;

@Bean
public class TmpStorage {
    private Admin admin;
    private Session session;
    
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }
}
