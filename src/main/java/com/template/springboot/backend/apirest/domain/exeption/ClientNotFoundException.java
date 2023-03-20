package com.template.springboot.backend.apirest.domain.exeption;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ClientNotFoundException extends RuntimeException {
    public static final String CLIENT_NOT_FOUND = "client with id %s not found";
    private final Long id;
}
