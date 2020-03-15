package com.hibernate.models.relationship.oneToMany.unidirectional.join;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class PostComment_OneToMany_join {

    @Id
    @GeneratedValue
    private Long id;

    private String review;

    public PostComment_OneToMany_join(String review) {
        this.review = review;
    }
}
