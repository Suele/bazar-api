package com.bazar.api.bazar.services;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.repositories.ProductPage;
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
    private Pageable pageable = PageRequest.of(0, 10);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPage productPage;

    public Product getId (Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O produto de id " + id + " não foi encontrado."));
    }

    public Page<Product> getAllProduct () {
        Page<Product> page = productRepository.findAll(pageable);
        if (page.getContent().size() > 0) {
            return page;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto foi cadastrado ainda.");
    }

    public Page<Product> getAllProductName (String productName) {
        Page<Product> page = productPage.findAllProductName(productName, pageable);
        if (page.getContent().size() > 0) {
            return page;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado.");
    }
}
