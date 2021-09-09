package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Sale")
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sale_id;

    @Column(nullable = false)
    private Double total;

    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "items", joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> items_sale = new HashSet<>();

    public Sale () {
    }

    public Sale (Long sale_id, Double total) {
        this.sale_id = sale_id;
        this.total = total;
    }

    public Long getSale_id () {
        return sale_id;
    }

    public void setSale_id (Long sale_id) {
        this.sale_id = sale_id;
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
                "sale_id:" + sale_id +
                ", total:" + total +
                ", items_sale:" + items_sale +
                '}';
    }
}
