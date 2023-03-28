package com.template.springboot.backend.domain.services;

import com.template.springboot.backend.domain.model.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-28T21:31:59+0200",
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
