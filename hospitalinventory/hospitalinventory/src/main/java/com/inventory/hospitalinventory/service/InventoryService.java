package com.inventory.hospitalinventory.service;

import com.inventory.hospitalinventory.dto.InventoryRequestDTO;
import com.inventory.hospitalinventory.dto.UseMedicineRequestDTO;
import com.inventory.hospitalinventory.entity.InventoryItem;

import java.util.List;

public interface InventoryService {

    InventoryItem addItem(InventoryRequestDTO dto);

    List<InventoryItem> getAllItems();
    void useMedicine(UseMedicineRequestDTO dto);


}