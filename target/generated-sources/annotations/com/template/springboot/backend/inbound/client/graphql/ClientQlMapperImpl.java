package com.template.springboot.backend.inbound.client.graphql;

import com.template.springboot.backend.outbound.client.ClientEntity;
import com.template.springboot.backend.outbound.client.ClientInput;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-29T20:35:35+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ClientQlMapperImpl implements ClientQlMapper {

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
