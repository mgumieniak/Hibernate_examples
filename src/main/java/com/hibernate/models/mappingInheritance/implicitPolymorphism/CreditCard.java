package com.hibernate.models.mappingInheritance.implicitPolymorphism;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false)
)
@Data
public class CreditCard extends BillingDetails implements Serializable {
    @Id
    @GeneratedValue
    private Long idCard;
    @NotNull
    private String cardNumber;
    @NotNull
    private String expMonth;
    @NotNull
    private String expYear;

    public CreditCard(@NotNull String owner, @NotNull String cardNumber, @NotNull String expMonth, @NotNull String expYear) {
        super(owner);
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
