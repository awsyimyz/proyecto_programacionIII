package com.desarrollo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDomain extends AddressDomain {
    private String name;
    private String surname;
    private String dni;
    private String mobile;
}
