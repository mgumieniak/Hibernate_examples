package com.hibernate.models.relationship.manyToOne.bi;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class PostComment_ManyToOne_bi {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post_ManyToOne_bi post;

    public PostComment_ManyToOne_bi() {
    }

    public PostComment_ManyToOne_bi(String title, Post_ManyToOne_bi post) {
        this.title = title;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostComment_ManyToOne_bi that = (PostComment_ManyToOne_bi) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
