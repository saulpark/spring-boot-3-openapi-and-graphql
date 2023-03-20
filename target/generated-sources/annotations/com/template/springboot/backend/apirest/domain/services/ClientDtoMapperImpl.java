package com.template.springboot.backend.apirest.domain.services;

import com.template.springboot.backend.apirest.domain.model.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-20T20:17:28+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ClientDtoMapperImpl implements ClientDtoMapper {

    @Override
    public void mergeClientDto(ClientDto existingClientDto, ClientDto clientDto) {
        if ( clientDto == null ) {
            return;
        }

        existingClientDto.setName( clientDto.getName() );
        existingClientDto.setLastName( clientDto.getLastName() );
        existingClientDto.setEmail( clientDto.getEmail() );
    }
}
