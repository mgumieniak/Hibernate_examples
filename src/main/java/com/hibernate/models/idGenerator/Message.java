package com.hibernate.models.idGenerator;

import com.hibernate.models.idGenerator.notnNullEmbeeded.MessageDetails;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Message", schema = "Hibernate")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pooled")
    @GenericGenerator(
            name = "pooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "sequence"),
                    @Parameter(name = "increment_size", value = "3"),
                    @Parameter(name = "optimizer", value = "pooled")
            }
    )
    private Long id;

    @NotNull
    private String text;

    private MessageDetails details;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
