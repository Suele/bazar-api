package com.bazar.api.bazar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Brand")
@Table(name = "brand")
public class Brand {
    @Id
    private Long id;

    @Column(nullable = true, length = 15)
    private String name;

    @ManyToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Product> products;

    public Brand () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public List<Product> getProducts () {
        return products;
    }
}
