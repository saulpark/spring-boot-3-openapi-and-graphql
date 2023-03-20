package com.template.springboot.backend.apirest.inbound.client;

import com.template.springboot.backend.apirest.domain.model.ClientDto;
import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.apirest.outbound.client.ClientEntity;
import com.template.springboot.backend.apirest.outbound.client.ClientInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto clientToClientDto (Client client);
    Client clientDtoToClient(ClientDto clientDto);

    /**
     * GRAPHQL MAPPER
     * @param clientInput
     * @return clientEntity
     */

    @Mapping(target = "items", ignore = true)
    ClientEntity clientInputToClientEntity(ClientInput clientInput);
}
