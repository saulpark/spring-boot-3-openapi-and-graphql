package com.template.springboot.backend.apirest.inbound.item;

import com.template.springboot.backend.apirest.outbound.client.ClientEntity;
import com.template.springboot.backend.apirest.outbound.item.ItemEntity;
import com.template.springboot.backend.apirest.outbound.item.ItemInput;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-20T20:17:28+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ItemInputMapperImpl implements ItemInputMapper {

    @Override
    public ItemEntity itemInputToItemEntity(ItemInput itemInput, ClientEntity clientEntity) {
        if ( itemInput == null && clientEntity == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        if ( itemInput != null ) {
            itemEntity.setItemName( itemInput.getItemName() );
        }
        itemEntity.setClientEntity( clientEntity );

        return itemEntity;
    }
}
