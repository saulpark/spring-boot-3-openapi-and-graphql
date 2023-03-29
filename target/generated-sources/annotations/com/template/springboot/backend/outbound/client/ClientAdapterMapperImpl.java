package com.template.springboot.backend.outbound.client;

import com.template.springboot.backend.domain.model.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-29T20:35:35+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ClientAdapterMapperImpl implements ClientAdapterMapper {

    @Override
    public ClientDto clientEntityToClientDto(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.id( clientEntity.getId() );
        clientDto.name( clientEntity.getName() );
        clientDto.lastName( clientEntity.getLastName() );
        clientDto.email( clientEntity.getEmail() );

        return clientDto.build();
    }

    @Override
    public ClientEntity clientDtoToClientEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( clientDto.getId() );
        clientEntity.setName( clientDto.getName() );
        clientEntity.setLastName( clientDto.getLastName() );
        clientEntity.setEmail( clientDto.getEmail() );

        clientEntity.setCreateAt( java.time.LocalDateTime.now() );

        return clientEntity;
    }
}
