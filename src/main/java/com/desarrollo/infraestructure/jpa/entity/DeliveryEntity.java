package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@Builder
@Data
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "dni", unique = true)
    private String dni;
    @Column(name = "mobile")
    private String mobile;
    @OneToOne
    @JoinColumn(name = "fk_id_address",updatable = false, nullable = false)
    private AddressEntity address;
}
