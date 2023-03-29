package com.template.springboot.backend.inbound.client.rest;

import com.template.springboot.backend.apirest.inbound.api.ClientApi;
import com.template.springboot.backend.apirest.inbound.api.ClientsApi;
import com.template.springboot.backend.apirest.inbound.api.RetryOnlyApi;
import com.template.springboot.backend.apirest.inbound.api.RetryWithRecoverApi;
import com.template.springboot.backend.apirest.inbound.dto.Client;
import com.template.springboot.backend.domain.services.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ClientRestController implements ClientApi, ClientsApi, RetryOnlyApi, RetryWithRecoverApi {

	private final ClientService clientService;
	private final ClientMapper clientMapper;

	@Override
	public ResponseEntity<Void> deleteClient(Integer id) {
		clientService.delete(Integer.toUnsignedLong(id));
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Client> getClientById(Integer id) {
		Client client = clientMapper.clientDtoToClient(clientService.findById(Integer.toUnsignedLong(id)));
		return ResponseEntity.ok(client);
	}

	@Override
	public ResponseEntity<Client> updateClient(Integer id, Client client) {
		Client responseClient = clientMapper.clientDtoToClient(
				clientService.update(Integer.toUnsignedLong(id), clientMapper.clientToClientDto(client)));
		return ResponseEntity.ok(responseClient);
	}

	@Override
	public ResponseEntity<Client> addClient(Client client) {
		Client responseClient = clientMapper.clientDtoToClient(
				clientService.save(clientMapper.clientToClientDto(client)));
		return ResponseEntity.ok(responseClient);
	}

	@Override
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> clients = clientService.getAllClients().stream()
				.map(clientMapper::clientDtoToClient)
				.toList();
		return ResponseEntity.ok(clients);
	}

	@Override
	public ResponseEntity<Void> retryOnly() {
		clientService.retryOnlyMethod();
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Void> retryRecover() {
		clientService.retryWithRecoverMethod();
		return ResponseEntity.ok().build();
	}
}
