package com.desarrollo.infraestructure.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Builder
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "street")
    private String street;
    @Column(name = "number_street")
    private String numberStreet;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "code_postal")
    private String codePostal;
    @Column(name = "description")
    private String description;
}
