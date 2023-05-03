package com.desarrollo.domain.spi;

import com.desarrollo.domain.model.CustomerDomain;

public interface CustomerPort {
    void save(CustomerDomain domain);
    CustomerDomain findCustomerByDni(String dni);
}
