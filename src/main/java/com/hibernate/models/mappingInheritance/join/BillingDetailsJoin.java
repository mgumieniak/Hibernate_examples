package com.hibernate.models.mappingInheritance.join;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetailsJoin {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String owner;

    public BillingDetailsJoin(@NotNull String owner) {
        this.owner = owner;
    }
}