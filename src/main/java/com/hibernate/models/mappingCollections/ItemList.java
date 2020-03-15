package com.hibernate.models.mappingCollections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class ItemList {
    @Id
    @GeneratedValue
    protected Long id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    private List<String> images = new ArrayList<>();
}
