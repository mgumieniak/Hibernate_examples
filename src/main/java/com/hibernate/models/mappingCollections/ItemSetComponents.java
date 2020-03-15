package com.hibernate.models.mappingCollections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "item_set_components")
public class ItemSetComponents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String author;


    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(
//            name = "images_set",
//            joinColumns = @JoinColumn(name = "item_set_components_id")
//    )
    private Set<Image> images = new HashSet<>();


    public ItemSetComponents(@NotNull String author, Set<Image> images) {
        this.author = author;
        this.images = images;
    }

    public ItemSetComponents() {
    }

}
