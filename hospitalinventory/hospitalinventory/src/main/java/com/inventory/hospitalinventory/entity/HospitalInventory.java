package com.inventory.hospitalinventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hospital_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    private Integer currentStock;

    private Integer dailyUsage;

    private Integer weeklyUsage;

    private Integer monthlyUsage;

    private Integer expiryRisk;

    private Boolean lowStock;
}
