package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code_order")
    private UUID codeOrder;
    @Column(name = "amount_total")
    private BigDecimal amountTotal;
    @Column(name = "iva")
    private BigDecimal iva;


    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private CustomerEntity customer;





}
