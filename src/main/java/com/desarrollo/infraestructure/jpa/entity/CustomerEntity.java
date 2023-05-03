package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
