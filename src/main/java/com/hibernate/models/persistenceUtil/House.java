package com.hibernate.models.persistenceUtil;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class House {
    @Id
    private Long id;

    private String owner;

    public House(Long id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public House() {
    }
}
