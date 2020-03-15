package com.hibernate.models.relationship.manyToOne.bi;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Post_ManyToOne_bi {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @OneToMany(
            mappedBy = "post",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PostComment_ManyToOne_bi> postComments = new HashSet<>();

    public Post_ManyToOne_bi(String review) {
        this.review = review;
    }

    public Post_ManyToOne_bi() {
    }

    public void addComment(PostComment_ManyToOne_bi comment) {
        postComments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment_ManyToOne_bi comment) {
        postComments.remove(comment);
        comment.setPost(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post_ManyToOne_bi that = (Post_ManyToOne_bi) o;
        return Objects.equals(getReview(), that.getReview());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReview());
    }
}
