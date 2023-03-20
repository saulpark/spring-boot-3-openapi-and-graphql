package com.template.springboot.backend.apirest.inbound.exception;

import com.template.springboot.backend.apirest.domain.exeption.ClientNotFoundException;
import com.template.springboot.backend.apirest.domain.exeption.ClientSaveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value = {ClientNotFoundException.class})
    protected ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException clientNotFoundException) {
        ExceptionResponse response = ExceptionResponse.builder()
                        .message(String.format(
                                ClientNotFoundException.CLIENT_NOT_FOUND, clientNotFoundException.getId()))
                .producedAt(LocalDateTime.now())
                .responseObject(clientNotFoundException.getId())
                .build();
        log.error(response.getMessage());
        return ResponseEntity
                .status(404)
                .body(response);
    }

    @ExceptionHandler (value = {ClientSaveException.class})
    protected ResponseEntity<Object> handleClientSaveException(ClientSaveException clientSaveException) {
        ExceptionResponse response = ExceptionResponse.builder()
                .message(String.format(
                        ClientSaveException.CLIENT_SAVE_ERROR, clientSaveException.getClientDto().getId()))
                .producedAt(LocalDateTime.now())
                .responseObject(clientSaveException.getClientDto())
                .build();
        log.error(response.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(response);
    }

}
