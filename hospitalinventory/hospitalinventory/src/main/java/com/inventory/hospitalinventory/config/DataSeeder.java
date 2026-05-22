package com.inventory.hospitalinventory.config;

import com.inventory.hospitalinventory.entity.Hospital;
import com.inventory.hospitalinventory.entity.Medicine;
import com.inventory.hospitalinventory.repository.HospitalRepository;
import com.inventory.hospitalinventory.repository.MedicineRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final HospitalRepository hospitalRepository;
    private final MedicineRepository medicineRepository;

    @PostConstruct
    public void seedData() {

        if (hospitalRepository.count() == 0) {

            hospitalRepository.save(
                    Hospital.builder()
                            .hospitalCode("H1")
                            .hospitalName("Apollo Hospital")
                            .location("Kolkata")
                            .build()
            );

            hospitalRepository.save(
                    Hospital.builder()
                            .hospitalCode("H2")
                            .hospitalName("Fortis")
                            .location("Delhi")
                            .build()
            );
        }

        if (medicineRepository.count() == 0) {

            medicineRepository.save(
                    Medicine.builder()
                            .medicineName("Paracetamol")
                            .category("Fever")
                            .thresholdLimit(50)
                            .build()
            );

            medicineRepository.save(
                    Medicine.builder()
                            .medicineName("Insulin")
                            .category("Diabetes")
                            .thresholdLimit(20)
                            .build()
            );
        }
    }
}
