package com.desarrollo.domain.spi;

import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;

import java.util.List;

public interface CustomerPort {
    void save(CustomerDomain domain);
    CustomerDomain findCustomerByDni(String dni);
    List<CustomerDomain>listAll();
    void delete(int id);
    CustomerDomain findById(int id);

    void save(AddressDomain addressDomain);


}
