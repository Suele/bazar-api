package com.bazar.api.bazar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, precision = 0)
    private Integer quantity;

    @Column(nullable = false, length = 15)
    private String product_type;

    @Column(nullable = false, length = 30)
    private String description;

    /*
    um produto pode pertencer a um ou muitos fornecedores
    e um fornecedor pode fornecer um ou muitos porodutos.
    */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "provider_id")
    private List<Provider> provider;

    /*
    um produto pode pertencer a um ou muitas marcas
    e uma marca pode pertencer a um ou muitos produtos
    */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "brand_id")
    private List<Brand>  brand;

    /*
    um produto pertence a uma categoria
    e uma categoria pertence a um produto
    */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;

    public Product () {
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public String getProduct_type () {
        return product_type;
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

}
