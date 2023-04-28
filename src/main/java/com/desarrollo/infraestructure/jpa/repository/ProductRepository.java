package com.desarrollo.infraestructure.jpa.repository;

import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
