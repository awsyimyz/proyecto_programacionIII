package com.desarrollo.domain.model;

import com.desarrollo.infraestructure.jpa.entity.CustomerEntity;
import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDetailDomain {

    private Integer id;
    private UUID codeOrder;
    private BigDecimal amountTotal;
    private BigDecimal iva;
    private List<ProductDomain> product;
    private CustomerDomain customer;
}
