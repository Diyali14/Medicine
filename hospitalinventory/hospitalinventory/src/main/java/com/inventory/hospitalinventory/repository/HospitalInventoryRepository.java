package com.inventory.hospitalinventory.repository;

import com.inventory.hospitalinventory.entity.Hospital;
import com.inventory.hospitalinventory.entity.HospitalInventory;
import com.inventory.hospitalinventory.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalInventoryRepository
        extends JpaRepository<HospitalInventory, Long> {

    List<HospitalInventory> findByHospital(Hospital hospital);

    Optional<HospitalInventory> findByHospitalAndMedicine(
            Hospital hospital,
            Medicine medicine
    );
}
