package com.desarrollo.infraestructure.jpa.mapper;

import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface ProductEntityMapper {

    ProductDomain toDomain(ProductEntity entity);

    ProductEntity toEntity(ProductDomain domain);
}
