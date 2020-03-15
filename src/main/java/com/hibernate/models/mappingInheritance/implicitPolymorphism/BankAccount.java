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
        column = @Column(name = "BA_OWNER", nullable = false)
)
@Data
public class BankAccount extends BillingDetails implements Serializable {
    @Id
    @GeneratedValue
    private Long idAccount;

    @NotNull
    private String bankname;

    public BankAccount(@NotNull String owner, @NotNull String bankname) {
        super(owner);
        this.bankname = bankname;
    }
}