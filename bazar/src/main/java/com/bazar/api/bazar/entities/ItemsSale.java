package com.bazar.api.bazar.entities;

import javax.persistence.*;
import java.util.Objects;

/*
 * Essa é a entidade que representa uma tabela no banco de dados.
 */

@Entity
@Table(name = "items_sale")
public class ItemsSale {
    @EmbeddedId
    private ItemsSaleKey idKeys;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("saleId")
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "quantity_sale", nullable = false)
    private Integer quantitySale;

    @Column(name = "unitary_value", nullable = false)
    private Double unitaryValue;

    public ItemsSale() {
    }

    public ItemsSale(Product product, Sale sale, Integer quantitySale, Double unitaryValue) {
        this.idKeys = new ItemsSaleKey(product.getProductId(), sale.getSaleId());
        this.product = product;
        this.sale = sale;
        this.quantitySale = quantitySale;
        this.unitaryValue = unitaryValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Integer getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(Integer quantitySale) {
        this.quantitySale = quantitySale;
    }

    public Double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsSale itemsSale = (ItemsSale) o;
        return Objects.equals(idKeys, itemsSale.idKeys) &&
                Objects.equals(product, itemsSale.product) &&
                Objects.equals(sale, itemsSale.sale) &&
                Objects.equals(quantitySale, itemsSale.quantitySale) &&
                Objects.equals(unitaryValue, itemsSale.unitaryValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKeys, product, sale, quantitySale, unitaryValue);
    }

    @Override
    public String toString() {
        return "ItemsSale{" +
                "idKeys:" + idKeys +
                ", product:" + product +
                ", sale:" + sale +
                ", quantitySale:" + quantitySale +
                ", unitaryValue:" + unitaryValue +
                '}';
    }
}