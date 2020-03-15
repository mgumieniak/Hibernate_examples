package com.hibernate.models.mappingInheritance.implicitPolymorphism;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@MappedSuperclass
public abstract class BillingDetails {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String owner;

    public BillingDetails(@NotNull String owner) {
        this.owner = owner;
    }
}