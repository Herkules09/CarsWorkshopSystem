package com.example.CarsWorkshopSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String mark;
    private LocalDate dateOfProduction;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "task_car_for_repair",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "car_for_repair_id"))
    private Set<CarForRepair> carsForRepair = new HashSet<>();


    public Car(String model, String mark, LocalDate dateOfProduction, Set<CarForRepair> carsForRepair) {
        this.model = model;
        this.mark = mark;
        this.dateOfProduction = dateOfProduction;
        this.carsForRepair = carsForRepair;
    }

    public Car(String mark, String model, LocalDate dateOfProduction){
        this.mark=mark;
        this.model=model;
        this.dateOfProduction=dateOfProduction;
    }
}
