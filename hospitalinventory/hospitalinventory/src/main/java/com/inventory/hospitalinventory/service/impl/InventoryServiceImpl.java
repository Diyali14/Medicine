package com.inventory.hospitalinventory.service.impl;

import com.inventory.hospitalinventory.dto.InventoryRequestDTO;
import com.inventory.hospitalinventory.dto.UseMedicineRequestDTO;
import com.inventory.hospitalinventory.entity.Hospital;
import com.inventory.hospitalinventory.entity.InventoryItem;
import com.inventory.hospitalinventory.repository.InventoryRepository;
import com.inventory.hospitalinventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.inventory.hospitalinventory.entity.HospitalInventory;
import com.inventory.hospitalinventory.entity.Medicine;
import com.inventory.hospitalinventory.repository.HospitalInventoryRepository;
import com.inventory.hospitalinventory.repository.HospitalRepository;
import com.inventory.hospitalinventory.repository.MedicineRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final HospitalRepository hospitalRepository;

    private final MedicineRepository medicineRepository;

    private final HospitalInventoryRepository hospitalInventoryRepository;




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

    @Override
    public void useMedicine(UseMedicineRequestDTO dto) {
        Hospital hospital = hospitalRepository
                .findById(dto.getHospitalId())
                .orElseThrow(() ->
                        new RuntimeException("Hospital not found"));

        Medicine medicine = medicineRepository
                .findById(dto.getMedicineId())
                .orElseThrow(() ->
                        new RuntimeException("Medicine not found"));

        HospitalInventory inventory = hospitalInventoryRepository
                .findByHospitalAndMedicine(hospital, medicine)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found"));

        if (dto.getQuantityUsed() > inventory.getCurrentStock()) {
            throw new RuntimeException("Insufficient stock available");
        }

        inventory.setCurrentStock(
                inventory.getCurrentStock() - dto.getQuantityUsed()
        );

        inventory.setLowStock(
                inventory.getCurrentStock()
                        <= medicine.getThresholdLimit()
        );

        hospitalInventoryRepository.save(inventory);
    }
}
