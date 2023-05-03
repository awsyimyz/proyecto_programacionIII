package com.desarrollo.infraestructure.config;

import com.desarrollo.domain.spi.AddressPort;
import com.desarrollo.domain.spi.CustomerPort;
import com.desarrollo.infraestructure.adapter.AddressAdapter;
import com.desarrollo.infraestructure.adapter.CustomerAdapter;
import com.desarrollo.infraestructure.jpa.mapper.AddressEntityMapper;
import com.desarrollo.infraestructure.jpa.mapper.CustomerEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.AddressRepository;
import com.desarrollo.infraestructure.jpa.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public CustomerPort getCustomerPort(final CustomerRepository repository, final CustomerEntityMapper mapper) {
        return new CustomerAdapter(repository, mapper);
    }

    @Bean
    public AddressPort getAddressPort(final AddressRepository repository, final AddressEntityMapper mapper) {
        return new AddressAdapter(repository, mapper);
    }
}
