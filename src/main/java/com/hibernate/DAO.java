package com.hibernate;

import com.hibernate.models.columnTransformer.Customer;
import com.hibernate.models.converter.Address;
import com.hibernate.models.converter.GermanZipcode;
import com.hibernate.models.converter.UserZipCode;
import com.hibernate.models.idGenerator.Message;
import com.hibernate.models.immutable.Info;
import com.hibernate.models.mappingCollections.Image;
import com.hibernate.models.mappingCollections.ItemSet;
import com.hibernate.models.mappingCollections.ItemSetComponents;
import com.hibernate.models.mappingInheritance.implicitPolymorphism.BankAccount;
import com.hibernate.models.mappingInheritance.implicitPolymorphism.BillingDetails;
import com.hibernate.models.mappingInheritance.implicitPolymorphism.CreditCard;
import com.hibernate.models.mappingInheritance.singleTable.BankAccountSingle;
import com.hibernate.models.mappingInheritance.singleTable.BillingDetailsSingle;
import com.hibernate.models.mappingInheritance.singleTable.CreditCardSingle;
import com.hibernate.models.mappingInheritance.tablePerClass.BankAccountUnion;
import com.hibernate.models.mappingInheritance.tablePerClass.BillingDetailsUnion;
import com.hibernate.models.mappingInheritance.tablePerClass.CreditCardUnion;
import com.hibernate.models.persistenceUtil.House;
import com.hibernate.models.proxy.entity.PostCommentProxy;
import com.hibernate.models.proxy.entity.PostProxy;
import com.hibernate.models.relationship.manyToOne.PostComment_ManyToOne;
import com.hibernate.models.relationship.manyToOne.Post_ManyToOne;
import com.hibernate.models.relationship.manyToOne.bi.PostComment_ManyToOne_bi;
import com.hibernate.models.relationship.manyToOne.bi.Post_ManyToOne_bi;
import com.hibernate.models.relationship.oneToMany.unidirectional.PostComment_OneToMany;
import com.hibernate.models.relationship.oneToMany.unidirectional.Post_OneToMany;
import com.hibernate.models.relationship.oneToMany.unidirectional.join.PostComment_OneToMany_join;
import com.hibernate.models.relationship.oneToMany.unidirectional.join.Post_OneToMany_join;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@Log
public class DAO {

    @PersistenceUnit
    private EntityManagerFactory emf;


    public void save_relationships() {
//        undirectionalManyToOne();
//        bidirectionalmanyToOne();
//        deletebidirectionalmanyToOne();
//        saveOneToMany();
//        saveOneToManyJoin();

//        simple_get_proxy();
    }

    private void simple_get_proxy() {
        PersistenceUnitUtil util = emf.getPersistenceUnitUtil();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        House house = new House(7L, "Maciej");
        util.isLoaded(house);

        em.persist(house);
        tx.commit();

        House houseRef = em.getReference(House.class, 7L);
        em.close();
    }

    private void saveOneToManyJoin() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post_OneToMany_join post = new Post_OneToMany_join(
                "Władca pierscieni - post",
                Arrays.asList(
                        new PostComment_OneToMany_join("Maciej"),
                        new PostComment_OneToMany_join("Angelika")
                )
        );
        em.persist(post);

        tx.commit();
        em.close();
    }

    private void saveOneToMany() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post_OneToMany post = new Post_OneToMany(
                "Władca pierscieni - post",
                Arrays.asList(
                        new PostComment_OneToMany("Maciej"),
                        new PostComment_OneToMany("Angelika")
                )
        );
        em.persist(post);

        tx.commit();
        em.close();
    }

    private void deletebidirectionalmanyToOne() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post_ManyToOne_bi post = em.find(Post_ManyToOne_bi.class, 56L);
        em.remove(post);

        tx.commit();
        em.close();
    }

    private void bidirectionalmanyToOne() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post_ManyToOne_bi post = new Post_ManyToOne_bi("Maciej Gumieniak");

        PostComment_ManyToOne_bi postComment = new PostComment_ManyToOne_bi("ManyToOne1", post);
        PostComment_ManyToOne_bi postComment2 = new PostComment_ManyToOne_bi("ManyToOne2", post);

        post.addComment(postComment);
        post.addComment(postComment2);

        em.persist(post);

        tx.commit();
        em.close();
    }

    private void undirectionalManyToOne() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post_ManyToOne post = new Post_ManyToOne("Maciej Gumieniak");
        em.persist(post);

        PostComment_ManyToOne postComment = new PostComment_ManyToOne("ManyToOne", post);
        em.persist(postComment);

        tx.commit();
        em.close();
    }


    public void save() {
//        saveMessage();
//        saveImmutable();
//        saveColumnTransformer();
//        saveConverter();
//        implicitPolymorphism();
//        tablePerClass();
//        inheritanceSingleTable();
//        mappingSet();
//        mappingSetComponent();

    }

    private void mappingSetComponent() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Set<Image> images = new HashSet<>();
        images.add(new Image("Kot", "kotFile", 640, 840));
        images.add(new Image("Kot", "kotFile", 840, 640));
        ItemSetComponents item = new ItemSetComponents("Maciej", images);

        em.persist(item);

        tx.commit();
        em.close();
    }

    private void mappingSet() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        ItemSet item = new ItemSet();
        item.setImages(Collections.singleton("Angelika"));

        em.persist(item);

        tx.commit();
        em.close();
    }

    private void inheritanceSingleTable() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        BillingDetailsSingle creditCard = new CreditCardSingle("Maciej", "123", "09", "2022");
        BillingDetailsSingle bankAccount = new BankAccountSingle("Maciej", "PEKAO");
        em.persist(creditCard);
        em.persist(bankAccount);
        tx.commit();
        em.close();
    }

    private void tablePerClass() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        BillingDetailsUnion creditCard = new CreditCardUnion("Maciej", "123", "09", "2022");
        BillingDetailsUnion bankAccount = new BankAccountUnion("Maciej", "PEKAO");
        em.persist(creditCard);
        em.persist(bankAccount);
        tx.commit();
        em.close();
    }

    private void implicitPolymorphism() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        BillingDetails creditCard = new CreditCard("Maciej", "123", "09", "2022");
        BillingDetails bankAccount = new BankAccount("Maciej", "PEKAO");
        em.persist(creditCard);
        em.persist(bankAccount);
        tx.commit();
        em.close();
    }

    private void saveConverter() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        UserZipCode userZipCode = new UserZipCode(new Address("Potockiego", new GermanZipcode("35322"), "Rzeszow"));

        em.persist(userZipCode);
        tx.commit();
        em.close();
    }

    private void saveColumnTransformer() {
        // Nalezy uzyc kodowania: utf8mb4
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = new Customer("Maciej", "Pawel", "123443210987");

        em.persist(customer);
        tx.commit();
        em.close();
    }


    private void saveImmutable() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Info info = new Info("Gelson", 2, 200);

        em.persist(info);
        tx.commit();
        em.close();
    }

    private void saveMessage() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Message message = new Message();
        message.setText("test");

        em.persist(message);
        tx.commit();
        em.close();
    }

    public void proxy() {
//        persistence_contexts_as_first_cache();

        EntityManager em = emf.createEntityManager();
        PersistenceUnitUtil util = emf.getPersistenceUnitUtil();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        tx.commit();
        em.close();
    }

    private void persistence_contexts_as_first_cache() {
        EntityManager em = emf.createEntityManager();
        PersistenceUnitUtil util = emf.getPersistenceUnitUtil();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Now Persistance Context is empty
        log.info("Find item - inject in persistence context");
        em.find(PostProxy.class, 1L); // get data from DB, nd add them in Persistance Context
        log.info("End find. SQL query should be between logs");

        // Now Persistance Context has one element


//        PostProxy post = em.find(PostProxy.class, 1L); -> uderza do bazy
        PostProxy post = em.getReference(PostProxy.class, 1L);
        log.info("Get id: " + post.getId());

        PostCommentProxy comment = new PostCommentProxy();
        comment.setReview("Maciej");
        comment.setPost(post);
        log.info("Print comment: " + comment.toString());

        em.persist(comment);
        tx.commit();

        em.clear(); // clear PC -> we fit to DB again
        log.info("After flush!");
        tx.begin();
        log.info("Get referance in new transaction");
        PostProxy postInNewTrans = em.getReference(PostProxy.class, 1L);
        System.out.println(postInNewTrans);
        tx.commit();

        em.close();
    }
}
