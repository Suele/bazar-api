package com.bazar.api.bazar;

import com.bazar.api.bazar.entities.Product;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

/*
 * Um carrinho de compras tem um ou muitos produtos
 */

public class Carrinho {
    private final List<Product> products;

    public Carrinho () {
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
        return this.products.stream().mapToDouble(Product::getValue_for_sale).sum();
    }

    public Long getQuantidadeDeItens () {
        return this.products.stream().count();
    }

    @Override
    public String toString () {
        return this.products
                + "Total: " + this.getTotal()
                + " Quantidade de Itens: " + this.getQuantidadeDeItens();
    }
}
