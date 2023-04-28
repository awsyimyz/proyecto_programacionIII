package com.desarrollo.infraestructure.jpa.repository;

import com.desarrollo.infraestructure.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
