package com.example.CarsWorkshopSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarRepairCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String address;
    private Float incomes;
    private Float expenses;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id",referencedColumnName = "id")
    private Worker manager;
    @OneToMany(mappedBy = "workingCarRepairCenter")
    private Set<Worker> workers = new HashSet<>();
    private Integer numberOfWorkers;
    @OneToMany
    private List<CarForRepair> carForRepairList;
    @OneToMany
    private List<CarForRent> carForRentList;
    @OneToMany
    private List<CarForReplace> carForReplaceList;
    @OneToMany(mappedBy = "carRepairCenter", cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();
}
