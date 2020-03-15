package com.hibernate.models.mappingInheritance.singleTable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CC")
public class CreditCardSingle extends BillingDetailsSingle {
    @NotNull
    private String cardNumber;
    @NotNull
    private String expMonth;
    @NotNull
    private String expYear;

    public CreditCardSingle(@NotNull String owner, @NotNull String cardNumber, @NotNull String expMonth, @NotNull String expYear) {
        super(owner);
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
