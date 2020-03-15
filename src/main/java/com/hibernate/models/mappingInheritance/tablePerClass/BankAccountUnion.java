package com.hibernate.models.mappingInheritance.tablePerClass;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class BankAccountUnion extends BillingDetailsUnion {

    @NotNull
    private String bankname;

    public BankAccountUnion(@NotNull String owner, @NotNull String bankname) {
        super(owner);
        this.bankname = bankname;
    }
}