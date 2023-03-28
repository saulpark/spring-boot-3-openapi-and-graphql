package com.template.springboot.backend.inbound.client.graphql;

import com.template.springboot.backend.inbound.item.ItemInputMapper;
import com.template.springboot.backend.outbound.client.ClientEntity;
import com.template.springboot.backend.outbound.client.ClientInput;
import com.template.springboot.backend.outbound.client.ClientRepository;
import com.template.springboot.backend.outbound.item.ItemEntity;
import com.template.springboot.backend.outbound.item.ItemInput;
import com.template.springboot.backend.outbound.item.ItemRepository;
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

    private final ClientQlMapper clientQlMapper;
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
        ClientEntity clientEntity = clientQlMapper.clientInputToClientEntity(clientInput);
        return clientRepository.save(clientEntity);
    }
}
