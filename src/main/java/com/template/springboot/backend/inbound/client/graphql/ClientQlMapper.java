package com.template.springboot.backend.inbound.client.graphql;

import com.template.springboot.backend.outbound.client.ClientEntity;
import com.template.springboot.backend.outbound.client.ClientInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientQlMapper {

    @Mapping(target = "items", ignore = true)
    ClientEntity clientInputToClientEntity(ClientInput clientInput);
}
