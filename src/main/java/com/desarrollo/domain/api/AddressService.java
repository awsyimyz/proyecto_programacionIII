package com.desarrollo.domain.api;

import com.desarrollo.domain.model.AddressDomain;

public interface AddressService {
    void save(AddressDomain domain);
    AddressDomain getById(int id);
}
