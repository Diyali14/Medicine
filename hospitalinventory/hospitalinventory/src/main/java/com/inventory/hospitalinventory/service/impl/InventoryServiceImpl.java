package com.inventory.hospitalinventory.service.impl;

import com.inventory.hospitalinventory.dto.InventoryRequestDTO;
import com.inventory.hospitalinventory.entity.InventoryItem;
import com.inventory.hospitalinventory.repository.InventoryRepository;
import com.inventory.hospitalinventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryItem addItem(InventoryRequestDTO dto) {

        InventoryItem item = InventoryItem.builder()
                .itemName(dto.getItemName())
                .category(dto.getCategory())
                .quantity(dto.getQuantity())
                .supplier(dto.getSupplier())
                .lowStock(dto.getQuantity() < 10)
                .build();

        return inventoryRepository.save(item);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }
}
