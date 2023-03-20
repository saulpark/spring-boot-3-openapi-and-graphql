package com.template.springboot.backend.apirest.inbound.client;

import com.template.springboot.backend.apirest.domain.model.ClientDto;
import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.apirest.outbound.client.ClientEntity;
import com.template.springboot.backend.apirest.outbound.client.ClientInput;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-20T20:17:27+0100",
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

    @Override
    public ClientEntity clientInputToClientEntity(ClientInput clientInput) {
        if ( clientInput == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setName( clientInput.getName() );
        clientEntity.setLastName( clientInput.getLastName() );
        clientEntity.setEmail( clientInput.getEmail() );
        if ( clientInput.getCreateAt() != null ) {
            clientEntity.setCreateAt( LocalDateTime.parse( clientInput.getCreateAt() ) );
        }

        return clientEntity;
    }
}
