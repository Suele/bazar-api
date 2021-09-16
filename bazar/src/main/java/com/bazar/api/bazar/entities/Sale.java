package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Sale")
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id", nullable = false)
    private Long saleId;

    @Column(nullable = false)
    private Double total;

    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "items_sale", joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> items_sale = new HashSet<>();

    public Sale () {
    }

    public Sale (Long sale_id, Double total) {
        this.saleId = sale_id;
        this.total = total;
    }

    public Long getSaleId () {
        return saleId;
    }

    public void setSaleId (Long saleId) {
        this.saleId = saleId;
    }

    public Double getTotal () {
        return total;
    }

    public void setTotal (Double total) {
        this.total = total;
    }

    public Set<Product> getItems_sale () {
        return items_sale;
    }

    public void setItems_sale (Set<Product> items_sale) {
        this.items_sale = items_sale;
    }

    @Override
    public String toString () {
        return "Sale{" +
                "saleId: " + saleId +
                ", total: " + total +
                ", items_sale: " + items_sale +
                '}';
    }
}
