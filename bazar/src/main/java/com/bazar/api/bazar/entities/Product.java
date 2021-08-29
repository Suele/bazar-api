package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
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
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "product_provider", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"))
    private List<Provider> provider;

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

    public Product (Long id, String name, Integer quantity, String product_type, String description, List<Provider> provider, List<Brand> brand, Category category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.product_type = product_type;
        this.description = description;
        this.provider = provider;
        this.brand = brand;
        this.category = category;
    }

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

    @Override
    public String toString () {
        return "Product{" +
                "id=" + id +
                ", name='" + name +
                ", quantity=" + quantity +
                ", product_type='" + product_type +
                ", description='" + description +
                ", provider=" + provider +
                ", brand=" + brand +
                ", category=" + category +
                '}';
    }
}
