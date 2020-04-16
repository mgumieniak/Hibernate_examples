package com.hibernate.models.proxy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostCommentProxy {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostProxy post;
}
