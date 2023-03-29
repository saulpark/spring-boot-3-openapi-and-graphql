package com.template.springboot.backend.inbound.client.rest;

import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.domain.model.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-29T20:35:35+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        if ( client.getId() != null ) {
            clientDto.id( client.getId().longValue() );
        }
        clientDto.name( client.getName() );
        clientDto.lastName( client.getLastName() );
        clientDto.email( client.getEmail() );

        return clientDto.build();
    }

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        if ( clientDto.getId() != null ) {
            client.setId( clientDto.getId().intValue() );
        }
        client.setName( clientDto.getName() );
        client.setLastName( clientDto.getLastName() );
        client.setEmail( clientDto.getEmail() );

        return client;
    }
}
