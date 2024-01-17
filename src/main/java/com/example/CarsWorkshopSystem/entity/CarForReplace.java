package com.example.CarsWorkshopSystem.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarForReplace extends Car{

    @Column(nullable = false)
    private String location;
    @ManyToOne
    @JoinColumn(name = "car_repair_center_id",referencedColumnName = "id")
    private CarRepairCenter carRepairCenter;
}
