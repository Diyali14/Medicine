package com.inventory.hospitalinventory.repository;

import com.inventory.hospitalinventory.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository
        extends JpaRepository<Hospital, Long> {
}
