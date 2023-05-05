package com.desarrollo.infraestructure.jpa.mapper;

import com.desarrollo.domain.model.OrderDetailDomain;
import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.infraestructure.jpa.entity.OrderDetailEntity;
import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import org.mapstruct.*;

import java.math.BigDecimal;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface OrderDetailEntityMapper {
    OrderDetailDomain toDomain(OrderDetailEntity entity);

    OrderDetailEntity toEntity(OrderDetailDomain domain);
    ProductEntity toEntity(ProductDomain productDomain);

}
