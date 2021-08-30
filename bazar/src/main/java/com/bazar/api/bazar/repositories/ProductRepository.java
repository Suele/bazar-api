package com.bazar.api.bazar.repositories;

import com.bazar.api.bazar.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT m FROM Product m")
    Page<Product> findAllProduct (Pageable pageable);
}
