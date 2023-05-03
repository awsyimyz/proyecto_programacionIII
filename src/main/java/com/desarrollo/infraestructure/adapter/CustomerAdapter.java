package com.desarrollo.infraestructure.adapter;

import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.spi.CustomerPort;
import com.desarrollo.infraestructure.jpa.mapper.CustomerEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerAdapter implements CustomerPort {

  private final CustomerRepository repository;

  private final CustomerEntityMapper mapper;

    public CustomerAdapter(CustomerRepository repository, CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(CustomerDomain domain) {
    log.info(" [INFRAESTRUCTURE] Pesistiendo un customer {} ",domain);
    repository.save(mapper.toEntity(domain));
    }

    @Override
    public CustomerDomain findCustomerByDni(String dni) {
        log.info(" [INFRAESTRUCTURE] Recuperando un customer por su Dni {} ",dni);
        return mapper.toDomain(repository.findByDni(dni));
    }
}
