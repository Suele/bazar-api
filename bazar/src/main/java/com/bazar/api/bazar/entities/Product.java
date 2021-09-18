package com.bazar.api.bazar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 23)
    private String productName;

    @Column(nullable = false, precision = 0)
    private Integer quantity;

    @Column(nullable = false, length = 35)
    private String description;

    @Column(name = "value_for_sale", nullable = false, precision = (7))
    private Double valueSale;

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

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Sale.class, mappedBy = "items_sale", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JsonIgnore
    private List<Sale> sale = new ArrayList<>();

    public Product () {
    }

    public Product (Long productId, String productName, Integer quantity, String description, Double valueSale, List<Provider> provider, List<Brand> brand, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.description = description;
        this.valueSale = valueSale;
        this.provider = provider;
        this.brand = brand;
        this.category = category;
    }

    public Long getProductId () {
        return productId;
    }

    public void setProductId (Long productId) {
        this.productId = productId;
    }

    public String getProductName () {
        return productName;
    }

    public void setProductName (String productName) {
        this.productName = productName;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public void setQuantity (Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Double getValueSale () {
        return valueSale;
    }

    public void setValueSale (Double valueSale) {
        this.valueSale = valueSale;
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

    public List<Sale> getSale () {
        return sale;
    }

    public void setSale (List<Sale> sale) {
        this.sale = sale;
    }

    @Override
    public String toString () {
        return "Product{" +
                "productId:" + productId +
                ", productName:'" + productName + '\'' +
                ", quantity:" + quantity +
                ", description:'" + description + '\'' +
                ", valueSale:" + valueSale +
                ", provider:" + provider +
                ", brand:" + brand +
                ", category:" + category +
                '}';
    }
}