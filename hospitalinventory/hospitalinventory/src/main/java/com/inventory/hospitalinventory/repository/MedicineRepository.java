package com.inventory.hospitalinventory.repository;

import com.inventory.hospitalinventory.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository
        extends JpaRepository<Medicine, Long> {
}
