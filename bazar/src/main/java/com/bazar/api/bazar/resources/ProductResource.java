package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductResource {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> products (Pageable pageable) {

        if (pageable.isPaged()) {
            return ResponseEntity.ok().body(productRepository.findAll(pageable));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductId (@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            return ResponseEntity.ok().body(productRepository.findById(id));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O id do produto pesquisado não existe");
        }
    }
}
