package com.desarrollo.domain.api;

import com.desarrollo.domain.model.CustomerDomain;

public interface CustomerService {

    void save(CustomerDomain domain);
    CustomerDomain getByDni(String dni);
}
