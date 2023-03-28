package com.template.springboot.backend.inbound.client.rest;

import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.domain.model.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto clientToClientDto (Client client);
    Client clientDtoToClient(ClientDto clientDto);
}
