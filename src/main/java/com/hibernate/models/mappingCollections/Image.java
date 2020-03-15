package com.hibernate.models.mappingCollections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class Image {

    protected String name;

    protected String filename;


    protected int width;


    protected int height;

    public Image() {
    }

    public Image(String name, String filename, int width, int height) {
        this.name = name;
        this.filename = filename;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return getWidth() == image.getWidth() &&
                getHeight() == image.getHeight() &&
                Objects.equals(getName(), image.getName()) &&
                Objects.equals(getFilename(), image.getFilename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFilename(), getWidth(), getHeight());
    }
}
