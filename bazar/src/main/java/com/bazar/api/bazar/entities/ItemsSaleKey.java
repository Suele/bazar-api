package com.bazar.api.bazar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/*
 * Classe que cria a chave composta formada por (product_id + sale_id)
 */
@Embeddable
public class ItemsSaleKey implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "sale_id")
    private Long saleId;

    public ItemsSaleKey() {
    }

    public ItemsSaleKey(Long productId, Long saleId) {
        this.productId = productId;
        this.saleId = saleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "ItemsSaleKey{" +
                "productId:" + productId +
                ", saleId:" + saleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsSaleKey that = (ItemsSaleKey) o;
        return Objects.equals(productId, that.productId) && Objects.equals(saleId, that.saleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, saleId);
    }
}
