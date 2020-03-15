package com.hibernate.models.relationship.oneToMany.unidirectional.join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post_OneToMany_join {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "post_id")
    private List<PostComment_OneToMany_join> comments = new ArrayList<>();

    public Post_OneToMany_join(String title, List<PostComment_OneToMany_join> comments) {
        this.title = title;
        this.comments = comments;
    }
}
