package com.hibernate.models.mappingInheritance.singleTable;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class BillingDetailsSingle {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String owner;

    public BillingDetailsSingle(@NotNull String owner) {
        this.owner = owner;
    }
}