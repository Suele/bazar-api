package com.bazar.api.bazar.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name_product;

    @Column(nullable = false, precision = 0)
    private Integer quantity;

    @Column(nullable = false, length = 15)
    private String product_type;

    @Column(nullable = false, length = 30)
    private String description;

    @Column(nullable = false, precision = (7))
    private Double value_for_sale;
    /*
        um produto pode pertencer a um ou muitos fornecedores
        e um fornecedor pode fornecer um ou muitos porodutos.
        */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "product_provider", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"))
    private List<Provider> provider;

    public Product () {
    }

    public Product (Long id, String name_product, Integer quantity, String product_type, String description, Double value_for_sale, List<Provider> provider, List<Brand> brand, Category category) {
        this.id = id;
        this.name_product = name_product;
        this.quantity = quantity;
        this.product_type = product_type;
        this.description = description;
        this.value_for_sale = value_for_sale;
        this.provider = provider;
        this.brand = brand;
        this.category = category;
    }

    /*
    um produto pode pertencer a um ou muitas marcas
    e uma marca pode pertencer a um ou muitos produtos
    */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "product_brand", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id"))
    private List<Brand> brand;

    /*
    um produto pertence a uma categoria
    e uma categoria pertence a um produto
    */
    @OneToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId () {
        return id;
    }

    public String getName_product () {
        return name_product;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public String getProduct_type () {
        return product_type;
    }

    public Double getValue_for_sale () {
        return value_for_sale;
    }

    public String getDescription () {
        return description;
    }

    public List<Provider> getProvider () {
        return provider;
    }

    public List<Brand> getBrand () {
        return brand;
    }

    public Category getCategory () {
        return category;
    }

    @Override
    @JsonCreator
    public String toString () {
        return
                "id:" + id +
                        " name_product:" + name_product +
                        " quantity:" + quantity +
                        " product_type:" + product_type +
                        " description:" + description +
                        " value_for_sale:" + value_for_sale;
    }
}
