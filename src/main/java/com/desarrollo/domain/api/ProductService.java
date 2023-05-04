package com.desarrollo.domain.api;

import com.desarrollo.domain.model.ProductDomain;

public interface ProductService {

    void save(ProductDomain domain);
    ProductDomain getByCodeProduct(String codeProduct);
    ProductDomain getByName(String name);

}
