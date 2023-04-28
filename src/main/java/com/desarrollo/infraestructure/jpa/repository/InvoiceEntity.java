package com.desarrollo.infraestructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceEntity extends JpaRepository<InvoiceEntity, UUID> {
}
