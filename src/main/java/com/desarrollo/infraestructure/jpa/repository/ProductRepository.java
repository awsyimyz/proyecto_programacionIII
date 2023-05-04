package com.desarrollo.infraestructure.jpa.repository;

import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    ProductEntity findByCodeProduct(UUID codeProduct);
    ProductEntity findByNameIgnoreCase(String name);
}
