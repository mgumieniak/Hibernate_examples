package com.hibernate.models.proxy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PostProxy {
    @Id
    private Long id;

    private String title;
}
