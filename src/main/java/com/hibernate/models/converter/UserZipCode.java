package com.hibernate.models.converter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class UserZipCode {
    @javax.persistence.Id
    @GeneratedValue
    private Long id;

    @Convert(
            converter = ZipcodeConverter.class,
            attributeName = "zipcode"
    )
    protected Address homeAddress;

    public UserZipCode(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
