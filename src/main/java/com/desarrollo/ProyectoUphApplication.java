package com.desarrollo;

import com.desarrollo.domain.api.CustomerService;
import com.desarrollo.domain.api.OrderDetailService;
import com.desarrollo.domain.api.ProductService;
import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.model.ProductDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class ProyectoUphApplication {

    private static CustomerService customerService;
    private static ProductService productService;
    private static OrderDetailService orderDetailService;

    public ProyectoUphApplication(CustomerService customerService, ProductService productService,OrderDetailService orderDetailService) {

        ProyectoUphApplication.customerService = customerService;
        ProyectoUphApplication.productService = productService;
        ProyectoUphApplication.orderDetailService = orderDetailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProyectoUphApplication.class, args);

        AddressDomain addressDomain = AddressDomain
                .builder()
                .city("Fuenlabrada")
                .codePostal("28944")
                .numberStreet("4B")
                .province("Madrid")
                .street("Extremadura")
                .description("Fente a supermecado DIA")
                .build();
        CustomerDomain customerDomain = CustomerDomain
                .builder()
                .name("Alex")
                .surname("Lopez")
                .mobile("632877894")
                .dni("Y6936124X")
                .address(addressDomain)
                .build();
        //customerService.save(customerDomain);
        //log.info("Este es un customer : " + customerService.getByDni("Y6936130C"));

        ProductDomain productDomain = ProductDomain.builder()
                .codeProduct(UUID.randomUUID())
                .description("Articulo para limpieza 100ml")
                .name("Azistin")
                .price(new BigDecimal(100.35))
                .build();

        //productService.save(productDomain);
        //log.info(" Un product name : " + productService.getByName("azistin"));
        //log.info(" Un product code: " + productService.getByCodeProduct("d5f4402e-8144-45a1-84c9-012cd0e79279"));

        CustomerDomain customer = customerService.getByDni("Y6936124X");
        ProductDomain product = productService.getByName("azistin");
        List<ProductDomain>list = List.of(product);
        OrderDetailDomain orderDetailDomain = OrderDetailDomain
                .builder()
                .iva(new BigDecimal(25.35))
                .amountTotal(new BigDecimal(190.66))
                .codeOrder(UUID.randomUUID())
                .customer(customer)
                .product(list)
                .build();
        orderDetailService.save(orderDetailDomain);

    }


}
