package com.hibernate.models.proxy.entity;

import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@BatchSize(size = 10)
public class User_proxy {
    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    protected String username;

    public User_proxy() {
    }

    public User_proxy(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
