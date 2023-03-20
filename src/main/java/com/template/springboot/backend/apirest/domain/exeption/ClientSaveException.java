package com.template.springboot.backend.apirest.domain.exeption;

import com.template.springboot.backend.apirest.domain.model.ClientDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientSaveException extends RuntimeException {
    public static final String CLIENT_SAVE_ERROR = "error saving client with id %s";
    private final ClientDto clientDto;

}
