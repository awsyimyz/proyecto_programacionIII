package com.desarrollo.application.config;

import com.desarrollo.domain.api.*;
import com.desarrollo.domain.spi.CustomerPort;
import com.desarrollo.domain.spi.OrderDetailPort;
import com.desarrollo.domain.spi.ProductPort;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCponfiguration {

    @Bean
    public CustomerService getCustomerService(final CustomerPort customerPort){
        return new CustomerServiceImpl(customerPort);
    }
    @Bean
    public ProductService getProductService(final ProductPort productPort){
        return new ProductServiceImpl(productPort);
    }

    @Bean
    public OrderDetailService getOrderDetailService(final OrderDetailPort orderDetailPort,final ProductPort productPort){
        return new OrderDetailServiceImpl(orderDetailPort, productPort);
    }
}
