package com.hibernate.models.mappingInheritance.singleTable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("BA")
public class BankAccountSingle extends BillingDetailsSingle {
    @NotNull
    private String bankname;

    public BankAccountSingle(@NotNull String owner, @NotNull String bankname) {
        super(owner);
        this.bankname = bankname;
    }
}