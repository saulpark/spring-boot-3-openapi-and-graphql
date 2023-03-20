package com.template.springboot.backend.apirest.inbound.item;

import com.template.springboot.backend.apirest.outbound.client.ClientEntity;
import com.template.springboot.backend.apirest.outbound.item.ItemEntity;
import com.template.springboot.backend.apirest.outbound.item.ItemInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemInputMapper {

    /**
     * GRAPHQL MAPPER
     */
    @Mapping(target = "id", ignore = true)
    ItemEntity itemInputToItemEntity(ItemInput itemInput, ClientEntity clientEntity);

}
