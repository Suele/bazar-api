package com.bazar.api.bazar.services;

import com.bazar.api.bazar.Carrinho;
import com.bazar.api.bazar.entities.Sale;
import com.bazar.api.bazar.repositories.ProductRepository;
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
    private ProductRepository productRepository;

    public void getItemsCart (Carrinho carrinho) {
        if (!carrinho.getProducts().isEmpty() && carrinho.getProducts().size() > 0) {
            sale.setItems_sale(carrinho.getProducts());
            sale.setTotal(carrinho.getTotal());
        }
    }


    public ResponseEntity<?> finallySale () {
        if (sale.getTotal() != null && sale.getItems_sale().size() > 0) {
            //TODO: antes de salvar a compra precisa verificar a quantidade disponível.

            saleRepository.save(sale);
            return ResponseEntity.ok().body("Compra finalizada com sucesso.");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto foi adicionado para compra.");
    }
}