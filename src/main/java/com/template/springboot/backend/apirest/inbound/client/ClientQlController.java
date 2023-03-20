package com.template.springboot.backend.apirest.inbound.client;

import com.template.springboot.backend.apirest.inbound.item.ItemInputMapper;
import com.template.springboot.backend.apirest.outbound.client.ClientEntity;
import com.template.springboot.backend.apirest.outbound.client.ClientInput;
import com.template.springboot.backend.apirest.outbound.client.ClientRepository;
import com.template.springboot.backend.apirest.outbound.item.ItemEntity;
import com.template.springboot.backend.apirest.outbound.item.ItemInput;
import com.template.springboot.backend.apirest.outbound.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientQlController {

    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;

    private final ClientMapper clientMapper;
    private final ItemInputMapper itemInputMapper;


    /*
    {
    clients {
        id
        name
        lastName
        createAt
        items {
            id
            itemName
            }
        }
    }
     */

    @QueryMapping
    public Iterable<ClientEntity> clients() {
        return clientRepository.findAll();
    }


    /*
     mutation {
     addClient(
       clientInput: {
     	name: "mutName"
       lastName: "mutLastName"
       email: "mutEmail"
       createAt: "2018-03-06T00:00"
       items: [
         {itemName: "mutItem1"}
         {itemName: "mutItem2"}
       ]
       }) {
         id
         name
         lastName
         email
         createAt
       }
     }
     */

    @MutationMapping
    @Transactional
    public ClientEntity addClient(@Argument ClientInput clientInput) {
        ClientEntity clientEntity = createClient(clientInput);
        if(clientInput.getItems() != null) {
            updateClientWithItems(clientEntity.getId(), clientInput.getItems());
        }
        return clientRepository.findById(clientEntity.getId())
                .orElseThrow(RuntimeException::new);
    }

    private void updateClientWithItems(Long id, List<ItemInput> items) {
        ClientEntity clientEntity = clientRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
       List<ItemEntity> entityItems = items.stream()
                .map(itemInput -> itemInputMapper.itemInputToItemEntity(itemInput, clientEntity))
                .toList();
        itemRepository.saveAll(entityItems);
    }

    private ClientEntity createClient(ClientInput clientInput) {
        ClientEntity clientEntity = clientMapper.clientInputToClientEntity(clientInput);
        return clientRepository.save(clientEntity);
    }
}
