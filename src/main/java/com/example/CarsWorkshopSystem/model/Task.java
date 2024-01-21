package com.example.CarsWorkshopSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private boolean done;
    private String description;
    @ManyToOne
    @JoinColumn(name = "car_repair_center_id",referencedColumnName = "id")
    private CarRepairCenter carRepairCenter;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "task_car_for_repair",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "car_for_repair_id"))
    private Set<CarForRepair> carsForRepair = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "task_worker",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id"))
    private Set<Worker> workers = new HashSet<>();

}
