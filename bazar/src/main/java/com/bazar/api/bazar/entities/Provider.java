package com.bazar.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Provider")
@Table(name = "provider")
public class Provider {
    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @ManyToMany(mappedBy = "provider")
    @JsonIgnore
    private List<Product> products;

    public Provider () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getCnpj () {
        return cnpj;
    }

    public List<Product> getProducts () {
        return products;
    }
}
