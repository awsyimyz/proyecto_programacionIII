package com.desarrollo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDomain extends PersonDomain{
    private Integer id;
    private AddressDomain addressDomain;

    @Override
    public String toString() {
        return  super.toString()+" "+" CustomerDomain{" +
                "id=" + id +
                '}';
    }
}
