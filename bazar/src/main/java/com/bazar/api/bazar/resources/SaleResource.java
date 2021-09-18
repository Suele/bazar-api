package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class SaleResource {
    @Autowired
    private SaleService saleService;

    @GetMapping("/items_sale")
    public ResponseEntity<?> newSale () {
        return saleService.getSale();
    }
}
