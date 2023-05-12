package com.desarrollo.infraestructure.adapter;

import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.spi.CustomerPort;
import com.desarrollo.infraestructure.jpa.entity.CustomerEntity;
import com.desarrollo.infraestructure.jpa.mapper.CustomerEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<CustomerDomain> listAll() {
        log.info(" [INFRAESTRUCTURE] Recuperando la lista de customer");
        return mapper.toListDomain(repository.findAll());
    }

    @Override
    public void delete(int id) {
        log.info(" [INFRAESTRUCTURE] borrando un customer por su Id {} ",id);
        repository.deleteById(id);

    }

    @Override
    public CustomerDomain findById(int id) {
        log.info(" [INFRAESTRUCTURE] Recuperando un customer por su Id {} ",id);
        Optional<CustomerEntity>customerDomain = repository.findById(id);
        return customerDomain.map(mapper::toDomain).orElse(null);
    }
}
