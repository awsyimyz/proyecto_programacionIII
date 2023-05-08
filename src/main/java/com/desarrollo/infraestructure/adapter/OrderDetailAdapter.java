package com.desarrollo.infraestructure.adapter;

import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.domain.spi.OrderDetailPort;
import com.desarrollo.infraestructure.jpa.entity.OrderDetailEntity;
import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import com.desarrollo.infraestructure.jpa.mapper.OrderDetailEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.OrderDetailRepository;
import com.desarrollo.infraestructure.jpa.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class OrderDetailAdapter implements OrderDetailPort {

    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final OrderDetailEntityMapper orderDetailEntityMapper;

    public OrderDetailAdapter(OrderDetailRepository orderDetailRepository, ProductRepository productRepository, OrderDetailEntityMapper orderDetailEntityMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.orderDetailEntityMapper = orderDetailEntityMapper;
    }

    @Override
    public void save(OrderDetailDomain domain) {
        log.info(" [INFRAESTRUCTURE] Pesistiendo una OrderDetail {} ",domain);
        OrderDetailEntity orderDetailEntity = orderDetailRepository.save(orderDetailEntityMapper.toEntity(domain));
    }

    @Override
    public OrderDetailDomain findById(int id) {
        log.info(" [INFRAESTRUCTURE] Recuperando una orderDetail por su ID {} ",id);
        return orderDetailEntityMapper.toDomain(orderDetailRepository.findById(id).orElse(null));
    }




}
