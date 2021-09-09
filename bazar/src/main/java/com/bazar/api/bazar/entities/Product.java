package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long product_id;

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

    @ManyToMany(targetEntity = Sale.class, mappedBy = "items_sale")
    private Set<Sale> sale = new HashSet<>();

    public Product () {
    }

    public Product (Long product_id, String name_product, Integer quantity, String product_type, String description, Double value_for_sale, List<Provider> provider, List<Brand> brand, Category category) {
        this.product_id = product_id;
        this.name_product = name_product;
        this.quantity = quantity;
        this.product_type = product_type;
        this.description = description;
        this.value_for_sale = value_for_sale;
        this.provider = provider;
        this.brand = brand;
        this.category = category;
    }

    public Long getId () {
        return product_id;
    }

    public void setId (Long product_id) {
        this.product_id = product_id;
    }

    public String getName_product () {
        return name_product;
    }

    public void setName_product (String name_product) {
        this.name_product = name_product;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public void setQuantity (Integer quantity) {
        this.quantity = quantity;
    }

    public String getProduct_type () {
        return product_type;
    }

    public void setProduct_type (String product_type) {
        this.product_type = product_type;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Double getValue_for_sale () {
        return value_for_sale;
    }

    public void setValue_for_sale (Double value_for_sale) {
        this.value_for_sale = value_for_sale;
    }

    public List<Provider> getProvider () {
        return provider;
    }

    public void setProvider (List<Provider> provider) {
        this.provider = provider;
    }

    public List<Brand> getBrand () {
        return brand;
    }

    public void setBrand (List<Brand> brand) {
        this.brand = brand;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }


    @Override
    public String toString () {
        return "Product{" +
                "id=" + product_id +
                ", name_product='" + name_product + '\'' +
                ", quantity=" + quantity +
                ", product_type='" + product_type + '\'' +
                ", description='" + description + '\'' +
                ", value_for_sale=" + value_for_sale +
                ", provider=" + provider +
                ", brand=" + brand +
                ", category=" + category +
                '}';
    }
}
