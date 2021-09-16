package com.bazar.api.bazar.repositories;

import com.bazar.api.bazar.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPage extends PagingAndSortingRepository<Product, Long> {
    @Query(value = "SELECT m FROM Product m WHERE m.productName LIKE :productName%")
    Page<Product> findAllProductName (@Param("productName") String productName, Pageable pageable);
}
