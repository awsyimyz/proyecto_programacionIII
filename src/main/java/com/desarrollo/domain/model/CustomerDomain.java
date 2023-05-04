package com.desarrollo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class CustomerDomain {
    private Integer id;
    private String name;
    private String surname;
    private String dni;
    private String mobile;
    private AddressDomain address;


}
