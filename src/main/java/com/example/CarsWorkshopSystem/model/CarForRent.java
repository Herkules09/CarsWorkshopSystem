package com.example.CarsWorkshopSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarForRent extends Car{

    @Column(nullable = false)
    private String color;
    private String comments;
    private String repairServices;
    @ManyToOne
    @JoinColumn(name = "car_repair_center_id",referencedColumnName = "id")
    private CarRepairCenter carRepairCenter;
}
