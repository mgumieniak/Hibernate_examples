package com.hibernate.models.mappingInheritance.tablePerClass;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CreditCardUnion extends BillingDetailsUnion {
    @NotNull
    private String cardNumber;
    @NotNull
    private String expMonth;
    @NotNull
    private String expYear;

    public CreditCardUnion(@NotNull String owner, @NotNull String cardNumber, @NotNull String expMonth, @NotNull String expYear) {
        super(owner);
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
