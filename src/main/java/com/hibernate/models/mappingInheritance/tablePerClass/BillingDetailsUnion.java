package com.hibernate.models.mappingInheritance.tablePerClass;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetailsUnion {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String owner;

    public BillingDetailsUnion(@NotNull String owner) {
        this.owner = owner;
    }
}