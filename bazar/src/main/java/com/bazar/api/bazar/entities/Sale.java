package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Sale")
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id", nullable = false)
    private Long saleId;

    @Column(nullable = false)
    private Double total;

    @OneToMany(mappedBy = "sale", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<ItemsSale> items_sale = new ArrayList<>();

    public Sale() {
    }

    public Sale(Long saleId, Double total) {
        this.saleId = saleId;
        this.total = total;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemsSale> getItems_sale() {
        return items_sale;
    }

    public void setItems_sale(List<ItemsSale> items_sale) {
        this.items_sale = items_sale;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId:" + saleId +
                ", total:" + total +
                ", items_sale:" + items_sale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(saleId, sale.saleId) && Objects.equals(total, sale.total) && Objects.equals(items_sale, sale.items_sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, total, items_sale);
    }
}