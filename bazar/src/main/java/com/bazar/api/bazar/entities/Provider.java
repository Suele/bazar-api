package com.bazar.api.bazar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Provider")
@Table(name = "provider")
public class Provider {

    @Id
    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(name = "provider_name", nullable = false, length = 25)
    private String providerName;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @ManyToMany(mappedBy = "provider")
    @JsonIgnore
    private List<Product> products;

    public Provider () {
    }

    public Provider (Long providerId, String providerName, String cnpj, List<Product> products) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.cnpj = cnpj;
        this.products = products;
    }

    public Long getProviderId () {
        return providerId;
    }

    public String getProviderName () {
        return providerName;
    }

    public String getCnpj () {
        return cnpj;
    }

    public List<Product> getProducts () {
        return products;
    }

    @Override
    public String toString () {
        return "Provider{" +
                "providerId:" + providerId +
                ", providerName:'" + providerName + '\'' +
                ", cnpj:'" + cnpj + '\'' +
                ", products:" + products +
                '}';
    }
}
