package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@Validated
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/")
    public ResponseEntity<Page<Product>> products () {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductId (@PathVariable(value = "id") @Min(value = 1, message = "id invalido.") Long id) {
        return ResponseEntity.ok().body(productService.getId(id));
    }

    @GetMapping("/products/{productName}")
    public ResponseEntity<?> getProductName (@PathVariable(value = "productName") String productName) {
        return ResponseEntity.ok().body(productService.getAllProductName(productName));
    }
}
