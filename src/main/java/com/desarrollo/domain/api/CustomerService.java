package com.desarrollo.domain.api;

import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;

import java.util.List;

public interface CustomerService {

    void save(CustomerDomain domain);
    CustomerDomain getByDni(String dni);
    List<CustomerDomain>getAll();
    void delete(int id);
    CustomerDomain getById(int id);
    void save(AddressDomain domain);
}
