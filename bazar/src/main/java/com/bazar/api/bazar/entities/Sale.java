package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Sale")
@Table(name = "sale")
public class Sale {
    @Id
    private Long sale_id;

    @Column(nullable = false)
    private LocalDate sale_date;

    @Column(nullable = false)
    private Double total;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "items_sale", joinColumns = @JoinColumn(name = "product_id"))
    private List<Product> items_sale;

    public Sale () {
    }

    public Sale (Long sale_id, Double total, List<Product> items_sale) {
        this.sale_id = sale_id;
        this.total = total;
        this.items_sale = items_sale;
    }

    public Long getSale_id () {
        return sale_id;
    }

    public void setSale_id (Long sale_id) {
        this.sale_id = sale_id;
    }

    public LocalDate getSale_date () {
        return sale_date;
    }

    private void setSale_date () {
        this.sale_date = LocalDate.now();
    }

    public Double getTotal () {
        return total;
    }

    public void setTotal (Double total) {
        this.total = total;
    }

    public List<Product> getItems_sale () {
        return items_sale;
    }

    public void setItems_sale (List<Product> items_sale) {
        this.items_sale = items_sale;
    }

    @Override
    public String toString () {
        return "Sale{" +
                "sale_id:" + sale_id +
                ", sale_date:" + sale_date +
                ", total:" + total +
                ", items_sale:" + items_sale +
                '}';
    }
}
