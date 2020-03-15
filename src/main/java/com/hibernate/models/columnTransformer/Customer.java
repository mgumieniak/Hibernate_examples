package com.hibernate.models.columnTransformer;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", updatable = false, nullable = false)
    private Long id;

    public Customer(String firstName, String lastName, String creditCardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNumber = creditCardNumber;
    }

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @ColumnTransformer(
            read ="AES_DECRYPT(creditCardNumber, 'my')",
            write = "AES_ENCRYPT(?, 'my')"
    )
    private String creditCardNumber;

}
