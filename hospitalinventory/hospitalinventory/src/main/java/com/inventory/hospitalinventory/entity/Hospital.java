package com.inventory.hospitalinventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalCode;

    private String hospitalName;

    private String location;
}
