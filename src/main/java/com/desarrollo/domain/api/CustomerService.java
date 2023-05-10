package com.desarrollo.domain.api;

import com.desarrollo.domain.model.CustomerDomain;

import java.util.List;

public interface CustomerService {

    void save(CustomerDomain domain);
    CustomerDomain getByDni(String dni);

    List<CustomerDomain>getAll();
}
