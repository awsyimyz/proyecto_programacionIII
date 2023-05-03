package com.desarrollo.domain.spi;

import com.desarrollo.domain.model.AddressDomain;

import java.util.Optional;

public interface AddressPort {
    void save(AddressDomain domain);

    Optional<AddressDomain> findAddressById(int id);
}
