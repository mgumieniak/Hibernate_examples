package com.hibernate.models.immutable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Info {
    private final String author;
    private final int highMeters;
    private final int highCentimetre;
    @Id
    @GeneratedValue
    private Long id;

    public Info(String author, int highMeters, int highCentimetre) {
        this.author = author;
        this.highMeters = highMeters;
        this.highCentimetre = highCentimetre;
    }
}
