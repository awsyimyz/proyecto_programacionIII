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
import java.util.ArrayList;
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
        //log.info("Este es un customer : " + customerService.getByDni("Y6936124X"));

        ProductDomain productDomain = ProductDomain.builder()
                .codeProduct(UUID.randomUUID())
                .description("Producto para cocina 1lb")
                .name("Carne para asar")
                .price(new BigDecimal(150.15))
                .verifyIva(false)
                .build();

        //productService.save(productDomain);
        //log.info(" Un product name : " + productService.getByName("Carne para asar"));
        //log.info(" Un product code: " + productService.getByCodeProduct("d5f4402e-8144-45a1-84c9-012cd0e79279"));

        CustomerDomain customer = customerService.getByDni("Y6936124X");
        //ProductDomain product = productService.getByName("azistin");
        ProductDomain product1 = productService.getByName("Carne para asar");
        List<ProductDomain>list = new ArrayList<>();
        //list.add(product);
        list.add(product1);

        OrderDetailDomain orderDetailDomain = OrderDetailDomain
                .builder()
                .iva(new BigDecimal(40.35))
                .amountTotal(new BigDecimal(500.66))
                .codeOrder(UUID.randomUUID())
                .customer(customer)
                .product(list)
                .build();


        orderDetailService.save(orderDetailDomain);

        log.info("OrderDetail {} ",orderDetailService.getById(1));

    }


}
