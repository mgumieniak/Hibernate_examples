package com.hibernate.models.relationship.manyToOne;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Post_ManyToOne {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    public Post_ManyToOne(String review) {
        this.review = review;
    }
}
