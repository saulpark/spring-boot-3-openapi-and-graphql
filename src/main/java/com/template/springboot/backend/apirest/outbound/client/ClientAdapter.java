package com.template.springboot.backend.apirest.outbound.client;

import com.template.springboot.backend.apirest.domain.client.ClientPort;
import com.template.springboot.backend.apirest.domain.model.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientAdapter implements ClientPort {

    private final ClientRepository clientRepository;
    private final ClientAdapterMapper clientAdapterMapper;

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientAdapterMapper::clientEntityToClientDto)
                .toList();
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        return clientAdapterMapper.clientEntityToClientDto(
                clientRepository.save(clientAdapterMapper.clientDtoToClientEntity(clientDto)));
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientAdapterMapper.clientEntityToClientDto(clientRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
