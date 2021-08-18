package com.bazar.api.bazar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    private Long id;

    @Column(nullable = true, length = 15)
    private String name;

    public Brand () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
