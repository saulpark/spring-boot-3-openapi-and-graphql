package com.template.springboot.backend.domain.model;

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
