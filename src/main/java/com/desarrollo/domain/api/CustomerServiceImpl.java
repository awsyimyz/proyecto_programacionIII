package com.desarrollo.domain.api;

import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.spi.CustomerPort;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerPort customerPort;


    public CustomerServiceImpl(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }


    @Override
    public void save(CustomerDomain domain) {
        log.info(" [DOMAIN] Pesistiendo un customer {} ", domain);
        domain.setAddress(domain.getAddress());
        customerPort.save(domain);
    }
    @Override
    public CustomerDomain getByDni(String dni) {
        log.info(" [DOMAIN] Recuperando un customer por su Dni {} ", dni);
        return customerPort.findCustomerByDni(dni);
    }
    @Override
    public List<CustomerDomain> getAll() {
        log.info(" [DOMAIN] Recuperando una lista customer");
        return customerPort.listAll();
    }

    @Override
    public void delete(int id) {
        log.info(" [DOMAIN] borrando un customer");
        customerPort.delete(id);
    }

    @Override
    public CustomerDomain getById(int id) {
        log.info(" [DOMAIN] Recuperando un customer por su Id {} ", id);
        return customerPort.findById(id);
    }


}
