package com.template.springboot.backend.outbound.client;

import com.template.springboot.backend.domain.model.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientAdapterMapper {
    ClientDto clientEntityToClientDto(ClientEntity clientEntity);
    @Mapping(target = "createAt", expression = "java(java.time.LocalDateTime.now())")
    ClientEntity clientDtoToClientEntity(ClientDto clientDto);
}
