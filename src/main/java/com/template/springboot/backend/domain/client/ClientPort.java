package com.template.springboot.backend.domain.client;

import com.template.springboot.backend.domain.model.ClientDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.util.List;

public interface ClientPort {
    List<ClientDto> getAllClients();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto getClientById(Long id);
    void deleteClient(Long id);
    @Retryable(retryFor = NullPointerException.class, maxAttempts = 2, backoff = @Backoff(delay = 5000))
    String testRetry();

    @Retryable(retryFor = NullPointerException.class, maxAttempts = 2, backoff = @Backoff(delay = 5000))
    String testRetryAndRecover(String message);

    @Recover
    String testRetryAndRecoverFallBack(String message);
}
