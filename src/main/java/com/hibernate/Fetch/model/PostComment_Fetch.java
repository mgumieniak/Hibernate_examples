package com.hibernate.Fetch.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PostComment_Fetch")
@Data
public class PostComment_Fetch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pooled")
    @GenericGenerator(
            name = "pooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "sequence"),
                    @Parameter(name = "increment_size", value = "5"),
                    @Parameter(name = "optimizer", value = "pooled")
            }
    )
    private Long id;
    private String title;
    private String review;

    public PostComment_Fetch(String title, String review) {
        this.title = title;
        this.review = review;
    }

    public PostComment_Fetch() {
    }



}
