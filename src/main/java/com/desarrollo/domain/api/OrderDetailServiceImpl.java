package com.desarrollo.domain.api;

import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.domain.spi.OrderDetailPort;
import com.desarrollo.domain.spi.ProductPort;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailPort orderDetailPort;
    private final ProductPort productPort;

    public OrderDetailServiceImpl(OrderDetailPort orderDetailPort, ProductPort productPort) {
        this.orderDetailPort = orderDetailPort;
        this.productPort = productPort;
    }

    @Override
    public void save(OrderDetailDomain domain) {
        log.info(" [DOMAIN] Pesistiendo una OrderDetail {} ", domain);
        orderDetailPort.save(domain);
    }

    @Override
    public OrderDetailDomain getById(int id) {
        log.info(" [DOMAIN] Recuperando una OrderDetail por su ID {} ", id);
        var order = orderDetailPort.findById(id);
        order.setProduct(order.getProduct());
      return order;
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

    private OrderDetailDomain getOrderDetailDomain(OrderDetailDomain order,ProductDomain productDomain){
        List<ProductDomain>list = new ArrayList<>();
        return OrderDetailDomain
                .builder()
                .customer(order.getCustomer())
                .product(getLisProduct(productDomain,order))
                .build();
    }

    private List<ProductDomain>getLisProduct(ProductDomain productDomain,OrderDetailDomain order){
        List<ProductDomain>list = new ArrayList<>();
        list.add(productDomain);
        return list;
    }
}
