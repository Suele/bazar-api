package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleResource {
    @Autowired
    private SaleService saleService;

    @PostMapping("/sale/")
    public ResponseEntity<Object> newSale (@RequestBody Product product) {
        return saleService.AddSale(product);
    }
}
