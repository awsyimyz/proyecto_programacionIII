package com.desarrollo.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDomain {
    private Integer id;
    private UUID codeProduct;
    private String name;
    private String description;
    private BigDecimal price;
}
