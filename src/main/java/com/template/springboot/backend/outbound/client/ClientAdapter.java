package com.template.springboot.backend.outbound.client;

import com.template.springboot.backend.domain.client.ClientPort;
import com.template.springboot.backend.domain.model.ClientDto;
import io.grpc.netty.shaded.io.netty.util.concurrent.ImmediateEventExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
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

    @Override
    public String testRetry() {
        log.error("retry exception at {}", LocalDateTime.now());
        List nullList = null;
        nullList.get(0);
        return Strings.EMPTY;
    }

    @Override
    public String testRetryAndRecover(String message) {
        log.error("retry exception at {} with message {}", LocalDateTime.now(), message);
        List nullList = null;
        nullList.get(0);
        return message;
    }

    @Override
    public String testRetryAndRecoverFallBack(String message) {
        log.info("recovering from error with message {} at {}", message, LocalDateTime.now());
        return "recovery " + message;
    }
}
