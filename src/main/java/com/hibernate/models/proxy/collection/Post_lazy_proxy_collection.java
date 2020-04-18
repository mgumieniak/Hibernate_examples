package com.hibernate.models.proxy.collection;

import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Post_lazy_proxy_collection {

    @Id
    private Long id;

    private String title;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @BatchSize(size = 5)
    private List<PostComment_lazy_proxy_collection> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Post_lazy_proxy_collection setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post_lazy_proxy_collection setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<PostComment_lazy_proxy_collection> getComments() {
        return comments;
    }

    public void addComment(PostComment_lazy_proxy_collection comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment_lazy_proxy_collection comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post_lazy_proxy_collection)) return false;
        return id != null && id.equals(((Post_lazy_proxy_collection) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
