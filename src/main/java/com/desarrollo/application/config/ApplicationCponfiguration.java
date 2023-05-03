package com.desarrollo.application.config;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.api.CustomerServiceImpl;
import com.desarrollo.domain.spi.AddressPort;
import com.desarrollo.domain.spi.CustomerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCponfiguration {

    @Bean
    public CustomerService getCustomerService(final CustomerPort customerPort , final AddressPort addressPort){
        return new CustomerServiceImpl(customerPort,addressPort);
    }
}
