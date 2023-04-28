package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "invoice")
@Builder
@Data
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "fk_id_order",updatable = false, nullable = false)
    private OrderEntity orderEntity;

    @Column(name = "date")
    private LocalDateTime date;


}
