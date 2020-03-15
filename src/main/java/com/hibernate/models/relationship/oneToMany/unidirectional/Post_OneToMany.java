package com.hibernate.models.relationship.oneToMany.unidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Table(name = "post")
public class Post_OneToMany {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment_OneToMany> comments = new ArrayList<>();

    public Post_OneToMany(String title, List<PostComment_OneToMany> comments) {
        this.title = title;
        this.comments = comments;
    }
}
