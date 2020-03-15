package com.hibernate.models.idGenerator.notnNullEmbeeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MessageDetails {
    @NotNull
    @Column(nullable = false)
    String author;
}
