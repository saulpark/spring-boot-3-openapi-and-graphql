package com.template.springboot.backend.apirest.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
