package com.desarrollo.domain.api;

import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.spi.AddressPort;
import com.desarrollo.domain.spi.CustomerPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerPort customerPort;

    private final AddressPort addressPort;

    public CustomerServiceImpl(CustomerPort customerPort, AddressPort addressPort) {
        this.customerPort = customerPort;
        this.addressPort = addressPort;
    }


    @Override
    public void save(CustomerDomain domain) {
        log.info(" [DOMAIN] Pesistiendo un customer {} ",domain);
        addressPort.save(domain.getAddressDomain());
        customerPort.save(domain);
    }

    @Override
    public CustomerDomain getByDni(String dni) {
        log.info(" [DOMAIN] Recuperando un customer por su Dni {} ",dni);
        return customerPort.findCustomerByDni(dni);
    }
}
