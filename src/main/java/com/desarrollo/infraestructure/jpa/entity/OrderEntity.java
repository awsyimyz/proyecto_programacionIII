package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_order")
    private LocalDateTime dateOrder;
    @Column(name = "status")
    private String status;
    @OneToOne
    @JoinColumn(name = "fk_order_detail",updatable = false, nullable = false)
    private OrderDetailEntity orderDetailEntity;

}
