package com.alberto.tupequenabiblioteca.dto;

import com.alberto.tupequenabiblioteca.entidades.Usuarios;

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