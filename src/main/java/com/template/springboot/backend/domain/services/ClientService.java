package com.template.springboot.backend.domain.services;

import com.template.springboot.backend.domain.exeption.ClientNotFoundException;
import com.template.springboot.backend.domain.client.ClientPort;
import com.template.springboot.backend.domain.exeption.ClientSaveException;
import com.template.springboot.backend.domain.model.ClientDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientPort clientPort;
	private final ClientDtoMapper clientDtoMapper;

	public List<ClientDto> getAllClients() {
        return clientPort.getAllClients();
	}

	public ClientDto findById(Long id) {
		ClientDto clientDto = clientPort.getClientById(id);
		if (clientDto == null) {
			throw new ClientNotFoundException(id);
		}
		return clientDto;
	}

	@SneakyThrows
	public ClientDto save(ClientDto clientDto) {
		try{
			return clientPort.saveClient(clientDto);
		}
		catch (RuntimeException exception) {
			throw new ClientSaveException(clientDto);
		}
	}

	public void delete(Long id) {
		clientPort.deleteClient(id);
	}

	public ClientDto update(Long id, ClientDto clientDto) {
		try {
			ClientDto existingClient = clientPort.getClientById(id);
			clientDtoMapper.mergeClientDto(existingClient, clientDto);
			return clientPort.saveClient(clientDto);
		}
		catch (IllegalArgumentException exception) {
				throw new ClientNotFoundException(id);
		}
	}

    public void retryOnlyMethod() {
		clientPort.testRetry();
	}

	public void retryWithRecoverMethod() {
		clientPort.testRetryAndRecover("test message");
	}
}
