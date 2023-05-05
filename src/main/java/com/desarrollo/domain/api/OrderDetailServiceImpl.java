package com.desarrollo.domain.api;

import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.domain.spi.OrderDetailPort;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailPort orderDetailPort;

    public OrderDetailServiceImpl(OrderDetailPort orderDetailPort) {
        this.orderDetailPort = orderDetailPort;
    }

    @Override
    public void save(OrderDetailDomain domain) {
        log.info(" [DOMAIN] Pesistiendo una OrderDetail {} ", domain);
        orderDetailPort.save(domain);
    }

    @Override
    public OrderDetailDomain getById(int id) {
        log.info(" [DOMAIN] Recuperando una OrderDetail por su ID {} ", id);
        return orderDetailPort.findById(id);
    }
/*
    private BigDecimal getPriceByTotal(List<ProductDomain>list){
        double totalPrice = 0;
        for (ProductDomain domain : list){
            if (domain.isIVA()){
             totalPrice =    domain.getPrice() *21/100;
            }
        }

    }

 */
}
