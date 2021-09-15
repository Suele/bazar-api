package com.bazar.api.bazar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Brand")
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "brand_name", nullable = true, length = 18)
    private String brandName;

    @ManyToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Product> products;

    public Brand () {
    }

    public Brand (Long brandId, String brandName, List<Product> products) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.products = products;
    }

    public Long getBrandId () {
        return brandId;
    }

    public String getBrandName () {
        return brandName;
    }

    public List<Product> getProducts () {
        return products;
    }

    @Override
    public String toString () {
        return "Brand{" +
                "brandId: " + brandId +
                ", brandName: '" + brandName + '\'' +
                ", products: " + products +
                '}';
    }
}
