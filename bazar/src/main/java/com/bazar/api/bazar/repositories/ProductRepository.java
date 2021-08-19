package com.bazar.api.bazar.repositories;

import com.bazar.api.bazar.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
