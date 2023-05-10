package com.desarrollo.infraestructure.jpa.mapper;

import com.desarrollo.domain.model.CustomerDomain;
import com.desarrollo.domain.model.ProductDomain;
import com.desarrollo.infraestructure.jpa.entity.CustomerEntity;
import com.desarrollo.infraestructure.jpa.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toEntity(CustomerDomain domain);

    CustomerDomain toDomain(CustomerEntity entity);

    List<CustomerDomain> toListDomain(List<CustomerEntity>list);

}
