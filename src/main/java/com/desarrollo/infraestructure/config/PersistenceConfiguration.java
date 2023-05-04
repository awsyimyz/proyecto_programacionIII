package com.desarrollo.infraestructure.config;

import com.desarrollo.domain.spi.CustomerPort;
import com.desarrollo.domain.spi.OrderDetailPort;
import com.desarrollo.domain.spi.ProductPort;
import com.desarrollo.infraestructure.adapter.CustomerAdapter;
import com.desarrollo.infraestructure.adapter.OrderDetailAdapter;
import com.desarrollo.infraestructure.adapter.ProductAdapter;
import com.desarrollo.infraestructure.jpa.mapper.CustomerEntityMapper;
import com.desarrollo.infraestructure.jpa.mapper.OrderDetailEntityMapper;
import com.desarrollo.infraestructure.jpa.mapper.ProductEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.CustomerRepository;
import com.desarrollo.infraestructure.jpa.repository.OrderDetailRepository;
import com.desarrollo.infraestructure.jpa.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public CustomerPort getCustomerPort(final CustomerRepository repository, final CustomerEntityMapper mapper) {
        return new CustomerAdapter(repository, mapper);
    }

    @Bean
    public ProductPort getProductPort(final ProductRepository repository, final ProductEntityMapper mapper) {
        return new ProductAdapter(repository, mapper);
    }

    @Bean
    public OrderDetailPort getOrderDetailPort(final OrderDetailRepository detailRepository,final ProductRepository repository , final OrderDetailEntityMapper mapper) {
        return new OrderDetailAdapter(detailRepository,repository,mapper);
    }
}
