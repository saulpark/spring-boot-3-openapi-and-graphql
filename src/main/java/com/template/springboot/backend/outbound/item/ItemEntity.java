package com.template.springboot.backend.outbound.item;

import com.template.springboot.backend.outbound.client.ClientEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity(name="item")
@RequiredArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "item_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @Column(name="name")
    private String itemName;
}
