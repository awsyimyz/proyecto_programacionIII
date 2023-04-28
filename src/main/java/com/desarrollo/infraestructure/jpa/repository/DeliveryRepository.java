package com.desarrollo.infraestructure.jpa.repository;

import com.desarrollo.infraestructure.jpa.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {
}
