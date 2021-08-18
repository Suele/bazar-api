package com.bazar.api.bazar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 14)
    private String cnpj;

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
}
