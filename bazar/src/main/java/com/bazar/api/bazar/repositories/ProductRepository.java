package com.bazar.api.bazar.repositories;

import com.bazar.api.bazar.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT m FROM Product m")
    Page<Product> findAllProduct (Pageable pageable);

    @Query(value = "SELECT m FROM Product m WHERE m.productName LIKE :productName%")
    Product findOneProduct (@Param("productName") String productName);

    //verifica se o produto existe e se a quantidade esta disponível.
    @Query(value = "SELECT m FROM Product m WHERE  m.productId = :productId AND m.quantity >= :quantity")
    Optional<Product> verifyProduct (@Param("productId") Long productId, @Param("quantity") Integer quantity);
}
