package com.template.springboot.backend.apirest.outbound.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

}
