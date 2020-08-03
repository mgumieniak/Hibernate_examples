package com.hibernate.springDao;

import com.hibernate.models.proxy.entity.PostProxy;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Log
@Service
public class SpringDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void getFirstTime() {
        log.info("Inside getFirstTime()");
        PostProxy proxy = em.find(PostProxy.class, 1L);
        log.info("Get first time object: " + proxy);
    }

    @Transactional
    public void getSecondTime() {
        log.info("Inside getSecondTime()");
        PostProxy proxy = em.getReference(PostProxy.class, 1L);
        log.info("Get second time object: " + proxy);
    }
}
