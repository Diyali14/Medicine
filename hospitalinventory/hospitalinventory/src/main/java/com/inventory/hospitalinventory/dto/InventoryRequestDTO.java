package com.inventory.hospitalinventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InventoryRequestDTO {

    @NotBlank
    private String itemName;

    @NotBlank
    private String category;

    @Min(0)
    private Integer quantity;

    private String supplier;
}
