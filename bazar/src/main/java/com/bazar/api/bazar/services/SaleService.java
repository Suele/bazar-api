package com.bazar.api.bazar.services;

import com.bazar.api.bazar.Carrinho;
import com.bazar.api.bazar.entities.Sale;
import com.bazar.api.bazar.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SaleService {
    private final Sale sale = new Sale();
    @Autowired
    private SaleRepository saleRepository;

    public ResponseEntity<Object> getItemsCart (Carrinho carrinho) {
        sale.setItems_sale(carrinho.getProducts());
        sale.setTotal(carrinho.getTotal());
        return ResponseEntity.ok().body(sale);
    }

    public ResponseEntity<?> getSale () {
        if (sale.getTotal() != null && sale.getItems_sale().size() > 0) {
            saleRepository.save(sale);
            return ResponseEntity.ok().body("A sua compra foi realizada com sucesso.");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto foi adicionado para compra.");
    }
}