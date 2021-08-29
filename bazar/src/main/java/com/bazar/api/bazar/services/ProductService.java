package com.bazar.api.bazar.services;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    private final Pageable pageable = PageRequest.of(0, 10);
    @Autowired
    private ProductRepository productRepository;

    public Product getId (Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O produto de id " + id + " não foi encontrado."));
    }

    public Page<Product> getAllProduct () {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getAllProductName (String productName) {
        return productRepository.findAllProductName(productName, pageable);

    }
}
