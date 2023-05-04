package com.desarrollo.domain.api;

import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.domain.spi.ProductPort;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductPort productPort;

    public ProductServiceImpl(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public void save(ProductDomain domain) {
        log.info(" [DOMAIN] Pesistiendo un Product {} ", domain);
        domain.setCodeProduct(UUID.randomUUID());
        productPort.save(domain);
    }
    @Override
    public ProductDomain getByCodeProduct(String codeProduct) {
        log.info(" [DOMAIN] Recuperando un Product por su Code Product {} ", codeProduct);
        return productPort.findByCodeProduct(codeProduct);
    }
    @Override
    public ProductDomain getByName(String name) {
        log.info(" [DOMAIN] Recuperando un Product por su Name {} ", name);
        return productPort.findByName(name);
    }
}
