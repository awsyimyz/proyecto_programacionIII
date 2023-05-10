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
/*
        AddressDomain addressDomain = AddressDomain
                .builder()
                .city("Mostoles")
                .codePostal("28935")
                .numberStreet("2A")
                .province("Madrid")
                .street("Pablo Segundo")
                .description("Fente a Estacion de renfe")
                .build();
        CustomerDomain customerDomain = CustomerDomain
                .builder()
                .name("Marcos Jose")
                .surname("Santos Medina")
                .mobile("602169807")
                .dni("Y8206435X")
                .address(addressDomain)
                .build();
        customerService.save(customerDomain);

 */
        /*
        //log.info("Este es un customer : " + customerService.getByDni("Y6936124X"));

        ProductDomain productDomain = ProductDomain.builder()
                .codeProduct(UUID.randomUUID())
                .description("Producto para cocina 1lb")
                .name("Hamburguesa")
                .price(new BigDecimal(150.15))
                .verifyIva(false)
                .build();

        //productService.save(productDomain);
        //log.info(" Un product name : " + productService.getByName("Enchiladas"));
        //log.info(" Un product code: " + productService.getByCodeProduct("d5f4402e-8144-45a1-84c9-012cd0e79279"));
        List<ProductDomain>list = new ArrayList<>();

        CustomerDomain customer = customerService.getByDni("Y6936124X");
        ProductDomain product = productService.getByName("Enchiladas");
        ProductDomain product1 = productService.getByName("Hamburguesa");
        list.add(product);
        list.add(product1);
        OrderDetailDomain orderDetailDomain = OrderDetailDomain
                .builder()
                .customer(customer)
                .codeOrder(UUID.randomUUID())
                .product(list)
                .iva(new BigDecimal(String.valueOf(getIva(list))))
                .amountTotal(new BigDecimal(String.valueOf(getAmountTotal(list))))
                .build();


        orderDetailService.save(orderDetailDomain);
        OrderDetailDomain domain1 = orderDetailService.getById(1);
        domain1.setProduct(orderDetailDomain.getProduct());

        log.info("OrderDetail {} ",domain1);

 */

    }

    public static BigDecimal getIva(List<ProductDomain>list){
        double total = 0;
        for (ProductDomain productDomain : list){
          total =  productDomain.getIva().doubleValue()+productDomain.getIva().doubleValue();
        }
        return new BigDecimal(total);
    }

    public static BigDecimal getAmountTotal(List<ProductDomain>list){
        double total = 0;
        for (ProductDomain productDomain : list){
            total =  productDomain.getPriceTotal().doubleValue()+productDomain.getPriceTotal().doubleValue();
        }
        return new BigDecimal(total);
    }
}
