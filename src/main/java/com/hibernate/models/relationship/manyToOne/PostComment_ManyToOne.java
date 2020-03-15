package com.hibernate.models.relationship.manyToOne;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostComment_ManyToOne {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post_ManyToOne post;

    public PostComment_ManyToOne(String title, Post_ManyToOne post) {
        this.title = title;
        this.post = post;
    }
}
