package com.bazar.api.bazar;

import com.bazar.api.bazar.entities.ItemsSale;
import com.bazar.api.bazar.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Um carrinho de compras tem um ou muitos produtos
 */

public class Cart {
    private final ItemsSale itemSale;
    private final ItemsSale ItemsProduct;
    private final List<Product> listProductAndSale;
    private final List<Product> products;

    public Cart() {
        this.ItemsProduct = new ItemsSale();
        this.itemSale = new ItemsSale();
        this.listProductAndSale = new ArrayList<Product>();
        this.products = new ArrayList<>();
    }

    public void addNewProduct(Product product) {
        this.ItemsProduct.setProduct(product);
        this.products.add(this.ItemsProduct.getProduct());

    }

    public List<Product> getProducts() {
        return this.products;
    }

    public List<Product> getSale() {
        return this.listProductAndSale.addAll(this.products);
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
        return "Cart{" +
                "itemSale=" + itemSale +
                ", ItemsProduct=" + ItemsProduct +
                ", listProductAndSale=" + listProductAndSale +
                ", products=" + products +
                '}';
    }
}
