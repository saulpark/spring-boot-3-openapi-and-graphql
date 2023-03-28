package com.template.springboot.backend.domain.client;

import com.template.springboot.backend.domain.model.ClientDto;

import java.util.List;

public interface ClientPort {
    List<ClientDto> getAllClients();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto getClientById(Long id);
    void deleteClient(Long id);
}
