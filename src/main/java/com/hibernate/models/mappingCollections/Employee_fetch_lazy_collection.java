package com.hibernate.models.mappingCollections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Employee_fetch_lazy_collection {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(
            name = "employee_phone",
            joinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Phone_lazy_collections> phones;

    public Employee_fetch_lazy_collection() {
    }

    public Employee_fetch_lazy_collection(String name, List<Phone_lazy_collections> phones) {
        this.name = name;
        this.phones = phones;
    }
}
