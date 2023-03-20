package com.template.springboot.backend.apirest.outbound.client;

import com.template.springboot.backend.apirest.outbound.item.ItemInput;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class ClientInput{
    private String name;
    private String lastName;
    private String email;
    private String createAt;
    private List<ItemInput> items;
}

