package com.hibernate;

import com.hibernate.springDao.SpringDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private DAO dao;
    private SpringDao springDao;

    public Controller(DAO dao, SpringDao springDao) {
        this.dao = dao;
        this.springDao = springDao;
    }

    @GetMapping
    public void get(){
        dao.save();
        dao.save_relationships();
        dao.proxy();
        dao.fetch();

//        test_persistance_contaext_range_in_spring();
    }

    private void test_persistance_contaext_range_in_spring() {
        springDao.getFirstTime();
        springDao.getSecondTime();
    }
}
