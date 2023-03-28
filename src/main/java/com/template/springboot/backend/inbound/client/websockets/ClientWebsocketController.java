package com.template.springboot.backend.inbound.client.websockets;

import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.domain.services.ClientService;
import com.template.springboot.backend.inbound.client.rest.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClientWebsocketController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @MessageMapping("/cli")
    @SendTo("/topic/cli")
    public Client getClient(@Payload Client client) {
        return clientMapper.clientDtoToClient(clientService.findById(Integer.toUnsignedLong(client.getId())));
    }
}
