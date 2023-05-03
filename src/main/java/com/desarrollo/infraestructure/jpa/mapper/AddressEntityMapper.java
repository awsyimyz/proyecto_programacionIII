package com.desarrollo.infraestructure.jpa.mapper;

import com.desarrollo.domain.model.AddressDomain;
import com.desarrollo.infraestructure.jpa.entity.AddressEntity;
import org.mapstruct.*;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public interface AddressEntityMapper {

    AddressEntity toEntity(AddressDomain domain);

    AddressDomain toDomain(AddressEntity entity);
}
