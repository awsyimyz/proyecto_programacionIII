package com.desarrollo.domain.model;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressDomain {
    private Integer id;
    private String street;
    private String numberStreet;
    private String province;
    private String city;
    private String codePostal;
    private String description;
}
