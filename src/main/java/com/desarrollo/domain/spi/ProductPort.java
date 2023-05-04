package com.desarrollo.domain.spi;

import com.desarrollo.domain.model.ProductDomain;

public interface ProductPort {
    void save(ProductDomain domain);
    ProductDomain findByCodeProduct(String codeProduct);
    ProductDomain findByName(String name);




}
