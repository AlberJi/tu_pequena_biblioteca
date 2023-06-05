package com.alberto.tu_pequena_biblioteca.dto;

import com.alberto.tu_pequena_biblioteca.entidades.Usuarios;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;



@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface JpaMapper {


    Usuarios toEntity(SignupRequest dto);
    SignupResponse toDto(Usuarios entity);


}