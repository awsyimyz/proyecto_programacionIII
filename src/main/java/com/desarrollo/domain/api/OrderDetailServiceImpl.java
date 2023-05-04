package com.desarrollo.domain.api;

import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.spi.OrderDetailPort;
import lombok.extern.slf4j.Slf4j;

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
}
