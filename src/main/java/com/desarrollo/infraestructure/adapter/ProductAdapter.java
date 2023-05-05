package com.desarrollo.infraestructure.adapter;

import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.domain.spi.ProductPort;
import com.desarrollo.infraestructure.jpa.mapper.ProductEntityMapper;
import com.desarrollo.infraestructure.jpa.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
public class ProductAdapter implements ProductPort {
    private final ProductRepository repository;
    private final ProductEntityMapper mapper;

    public ProductAdapter(ProductRepository repository, ProductEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(ProductDomain domain) {
        log.info(" [INFRAESTRUCTURE] Pesistiendo un Product {} ",domain);
        domain.setIva(getIva(domain));
        domain.setPriceTotal(getPriceTotal(domain));
        repository.save(mapper.toEntity(domain));
    }

    @Override
    public ProductDomain findByCodeProduct(String codeProduct) {
        log.info(" [INFRAESTRUCTURE] Recuperar un product por su code product {} ",codeProduct);
        return mapper.toDomain(repository.findByCodeProduct(UUID.fromString(codeProduct)));
    }

    @Override
    public ProductDomain findByName(String name) {
        log.info(" [INFRAESTRUCTURE] Recuperar un product por su name {} ",name);
        return mapper.toDomain(repository.findByNameIgnoreCase(name));
    }

    private BigDecimal getIva(ProductDomain domain){
        double iva = 0;
        if (domain.getVerifyIva()){
          iva =  domain.getPrice().doubleValue() * 21 /100;
        }
        return new BigDecimal(iva);
    }

    private BigDecimal getPriceTotal(ProductDomain domain){
        double priceTotal = getIva(domain).doubleValue() + domain.getPrice().doubleValue();
        return new BigDecimal(priceTotal);
    }


}
