package com.hibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private DAO dao;

    public Controller(DAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public void get(){
        dao.save();
        dao.save_relationships();
    }
}
