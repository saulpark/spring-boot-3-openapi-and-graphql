package com.template.springboot.backend.outbound.client;

import com.template.springboot.backend.outbound.item.ItemEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name="client")
@RequiredArgsConstructor
public class ClientEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "client_id")
        private Long id;

        @Column(name="name")
        private String name;
        @Column(name="last_name")
        private String lastName;
        @Column(name="email")
        private String email;
        @Column(name="create_at")
        @DateTimeFormat
        private LocalDateTime createAt;

        @OneToMany(mappedBy = "clientEntity", fetch = FetchType.EAGER)
        private List<ItemEntity> items;
}
