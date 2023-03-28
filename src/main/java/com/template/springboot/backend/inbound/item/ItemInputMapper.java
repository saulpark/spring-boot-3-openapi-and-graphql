package com.template.springboot.backend.inbound.item;

import com.template.springboot.backend.outbound.client.ClientEntity;
import com.template.springboot.backend.outbound.item.ItemEntity;
import com.template.springboot.backend.outbound.item.ItemInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemInputMapper {
    @Mapping(target = "id", ignore = true)
    ItemEntity itemInputToItemEntity(ItemInput itemInput, ClientEntity clientEntity);
}