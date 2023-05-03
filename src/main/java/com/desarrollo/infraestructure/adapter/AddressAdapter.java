package com.desarrollo.infraestructure.adapter;

import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.spi.AddressPort;
import com.desarrollo.infraestructure.jpa.entity.AddressEntity;
import com.desarrollo.infraestructure.jpa.mapper.AddressEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class AddressAdapter implements AddressPort {

    private final AddressRepository repository;

    private final AddressEntityMapper mapper;

    public AddressAdapter(AddressRepository repository, AddressEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(AddressDomain domain) {
        log.info(" [INFRAESTRUCTURE] Pesistiendo una Address {} ", domain);
        repository.save(mapper.toEntity(domain));
    }

    @Override
    public Optional<AddressDomain> findAddressById(int id) {
        log.info(" [INFRAESTRUCTURE] Recuperando una Address por su Id {} ",id);
        Optional<AddressEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain);

    }
}
