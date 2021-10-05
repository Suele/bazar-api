package com.bazar.api.bazar;

import com.bazar.api.bazar.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Um carrinho de compras tem um ou muitos produtos
 */

public class Cart {
    private final List<Product> products;
    private final Product product;

    public Cart() {
        this.product = new Product();
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        if (!this.products.isEmpty()) {
            return this.products;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seu carrinho está vazio.");
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    public Double getTotal() {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        this.products.forEach(product -> {
            total.updateAndGet(v -> v + product.getQuantity() * product.getValueSale());
        });
        return total.get();
    }

    public Integer getQuantidadeDeItens() {
        AtomicReference<Integer> quantity = new AtomicReference<>(0);
        this.products.forEach(product -> {
            quantity.updateAndGet(v -> v + product.getQuantity());
        });
        return quantity.get();
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "products:" + this.products +
                ",Itens:" + this.getQuantidadeDeItens() +
                ",Total:" + this.getTotal() +
                '}';
    }
}
