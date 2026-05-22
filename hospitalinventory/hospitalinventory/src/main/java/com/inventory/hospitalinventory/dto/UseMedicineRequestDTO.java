package com.inventory.hospitalinventory.dto;

import lombok.Data;

@Data
public class UseMedicineRequestDTO {

    private Long hospitalId;

    private Long medicineId;

    private Integer quantityUsed;
}
