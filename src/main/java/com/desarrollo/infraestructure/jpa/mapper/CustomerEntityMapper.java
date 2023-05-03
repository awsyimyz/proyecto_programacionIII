package com.desarrollo.infraestructure.jpa.mapper;

import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.infraestructure.jpa.entity.CustomerEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toEntity(CustomerDomain domain);

    CustomerDomain toDomain(CustomerEntity entity);
}
