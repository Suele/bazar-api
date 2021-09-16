package com.bazar.api.bazar;

import com.bazar.api.bazar.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Um carrinho de compras tem um ou muitos produtos
 */

public class Carrinho {
    private final List<Product> products;
    private Product product;

    public Carrinho () {
        this.product = new Product();
        this.products = new ArrayList<>();
    }

    public Carrinho (List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts () {
        return this.products;
    }

    public void setProducts (Product products) {
        this.products.add(products);
    }

    public Double getTotal () {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        this.products.forEach(product -> {
            total.updateAndGet(v -> v + product.getQuantity() * product.getValueSale());
        });
        return total.get();
    }

    public Integer getQuantidadeDeItens () {
        AtomicReference<Integer> quantity = new AtomicReference<>(0);
        this.products.forEach(product -> {
            quantity.updateAndGet(v -> v + product.getQuantity());
        });
        return quantity.get();
    }

    @Override
    public String toString () {
        return "Carrinho{" +
                "products:" + this.products +
                ",Itens:" + this.getQuantidadeDeItens() +
                ",Total:" + this.getTotal() +
                '}';
    }
}
