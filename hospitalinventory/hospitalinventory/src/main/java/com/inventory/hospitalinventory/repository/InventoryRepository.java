package com.inventory.hospitalinventory.repository;

import com.inventory.hospitalinventory.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository
        extends JpaRepository<InventoryItem, Long> {
}