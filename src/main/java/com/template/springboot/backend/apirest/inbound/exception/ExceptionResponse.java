package com.template.springboot.backend.apirest.inbound.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionResponse {
    private LocalDateTime producedAt;
    private String message;
    private Object responseObject;
}
