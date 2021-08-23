package com.bazar.api.bazar.services;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Pageable pageable = Pageable.unpaged();
    @Autowired
    private ProductRepository productRepository;

    public Product getId (Long id) {
        return productRepository.findById(id).get();
    }

    public Page<Product> getAllProduct () {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getAllProductName (String productName) {
        return productRepository.findAllProductName(productName, pageable);
    }
}
