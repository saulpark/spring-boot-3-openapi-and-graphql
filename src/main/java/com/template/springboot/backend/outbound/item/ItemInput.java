package com.template.springboot.backend.outbound.item;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ItemInput {
    private String itemName;
}
