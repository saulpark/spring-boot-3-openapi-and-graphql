package com.template.springboot.backend.apirest.domain.client;

import com.template.springboot.backend.apirest.domain.model.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientPort {
    List<ClientDto> getAllClients();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto getClientById(Long id);
    void deleteClient(Long id);
}
