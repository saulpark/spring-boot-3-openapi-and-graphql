package com.template.springboot.backend.apirest.domain.services;

import com.template.springboot.backend.apirest.domain.model.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {
    @Mapping(target = "id", ignore = true)
    void mergeClientDto(@MappingTarget ClientDto existingClientDto, ClientDto clientDto);
}
