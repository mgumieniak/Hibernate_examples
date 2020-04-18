package com.hibernate.models.proxy.collection;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class PostComment_lazy_proxy_collection {

    @Id
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post_lazy_proxy_collection post;

    public Long getId() {
        return id;
    }

    public PostComment_lazy_proxy_collection setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReview() {
        return review;
    }

    public PostComment_lazy_proxy_collection setReview(String review) {
        this.review = review;
        return this;
    }

    public Post_lazy_proxy_collection getPost() {
        return post;
    }

    public PostComment_lazy_proxy_collection setPost(Post_lazy_proxy_collection post) {
        this.post = post;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment_lazy_proxy_collection)) return false;
        return id != null && id.equals(((PostComment_lazy_proxy_collection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", post=" + post +
                '}';
    }
}
