package com.bazar.api.bazar.resources;

import com.bazar.api.bazar.services.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Compras")

@RestController
public class SaleResource {
    @Autowired
    private SaleService saleService;

    @ApiOperation(value = "Pega os produtos do carrinho de compras e finaliza a compra")
    @GetMapping("/finally_sale")
    public ResponseEntity<?> newSale () {
        return saleService.finallySale();
    }
}
