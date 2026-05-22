package com.inventory.hospitalinventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "inventory_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotBlank(message = "Category is required")
    private String category;

    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    private String supplier;

    private Boolean lowStock;
}