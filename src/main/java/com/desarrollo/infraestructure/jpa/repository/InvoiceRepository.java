package com.desarrollo.infraestructure.jpa.repository;

import com.desarrollo.infraestructure.jpa.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {
}
