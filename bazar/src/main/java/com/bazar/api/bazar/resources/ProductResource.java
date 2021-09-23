package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Api(tags = "Produto")
@RestController
@Validated
public class ProductResource {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Lista todos os produtos")
    @GetMapping("/products/")
    public ResponseEntity<Page<Product>> products () {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @ApiOperation(value = "Busca um produto pelo id")
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductId (@PathVariable(value = "id") @Min(value = 1, message = "id invalido.") Long id) {
        return ResponseEntity.ok().body(productService.getId(id));
    }

    @ApiOperation(value = "Busca produto por nome")
    @GetMapping("/products/{productName}")
    public ResponseEntity<?> getProductName (@PathVariable(value = "productName") String productName) {
        return ResponseEntity.ok().body(productService.getAllProductName(productName));
    }

    @ApiOperation(value = "Adiciona produtos no carrinho de compras.")
    @PostMapping("/items_cart")
    public ResponseEntity<?> itemsCart (@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.itemsCart(product));
    }
}