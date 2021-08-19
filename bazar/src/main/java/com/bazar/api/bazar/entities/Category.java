package com.bazar.api.bazar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private Long id;

    @Column(nullable = false, length = 18)
    private String name;

    public Category () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
