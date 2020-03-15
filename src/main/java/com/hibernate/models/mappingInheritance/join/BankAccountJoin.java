package com.hibernate.models.mappingInheritance.join;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BankAccountJoin extends BillingDetailsJoin {
    @NotNull
    private String bankname;

    public BankAccountJoin(@NotNull String owner, @NotNull String bankname) {
        super(owner);
        this.bankname = bankname;
    }
}