package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.Cart;
import com.bazar.api.bazar.entities.ItemsSale;
import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(tags = "Produto")
@RestController
@Validated
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Lista todos os produtos")
    @GetMapping("/list")
    public ResponseEntity<Page<Product>> products() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @ApiOperation(value = "Busca produto pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductId(@PathVariable(value = "id") Long id) {
        return productService.getId(id);
    }

    @ApiOperation(value = "Busca produto por nome")
    @GetMapping("/search/{productName}")
    public ResponseEntity<?> getProductName(@PathVariable(value = "productName") String productName) {
        return ResponseEntity.ok().body(productService.getAllProductName(productName));
    }

    @ApiOperation(value = "Adiciona produtos no carrinho de compras.")
    @PostMapping("/add")
    public void addItemsCart(@RequestBody Product product) {
        productService.addItemsCart(product);
    }

    @ApiOperation(value = "Mostra os itens do carrinho de compras.")
    @GetMapping("/cart")
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok().body(productService.getCart());
    }

    @ApiOperation(value = "Pega os produtos que estão no carrinho e efetua a compra.")
    @GetMapping("/sale")
    public ResponseEntity<ItemsSale> newSale() {
        return ResponseEntity.ok().body(productService.finallySale());
    }
}