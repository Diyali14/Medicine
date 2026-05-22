package com.inventory.hospitalinventory.controller;

import com.inventory.hospitalinventory.dto.InventoryRequestDTO;
import com.inventory.hospitalinventory.entity.InventoryItem;
import com.inventory.hospitalinventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryItem> addItem(
            @Valid @RequestBody InventoryRequestDTO dto
    ) {

        return ResponseEntity.ok(
                inventoryService.addItem(dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllItems() {

        return ResponseEntity.ok(
                inventoryService.getAllItems()
        );
    }
}