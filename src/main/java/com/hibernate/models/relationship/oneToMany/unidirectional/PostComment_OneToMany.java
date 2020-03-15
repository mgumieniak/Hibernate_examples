package com.hibernate.models.relationship.oneToMany.unidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment_OneToMany {

    @Id
    @GeneratedValue
    private Long id;

    private String review;

    public PostComment_OneToMany(String review) {
        this.review = review;
    }
}
