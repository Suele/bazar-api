package com.bazar.api.bazar.services;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.entities.Sale;
import com.bazar.api.bazar.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public ResponseEntity<Object> AddSale (Product product) {
        Sale sale = new Sale();
        Set<Product> productList = new HashSet<>();

        sale.setTotal(product.getValue_for_sale());
        productList.add(product);
        sale.setItems_sale(productList);

        saleRepository.save(sale);
        return ResponseEntity.ok().body(sale);
    }
}
