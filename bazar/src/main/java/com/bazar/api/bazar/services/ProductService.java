package com.bazar.api.bazar.services;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getId (Long id) {
        if (id != null && productRepository.existsById(id) && productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        throw new RuntimeException("id nao encontrado.");
    }

    public Page<Product> getAllProduct () {

        Pageable pageable = Pageable.unpaged();
        return productRepository.findAll(pageable);
    }
}
