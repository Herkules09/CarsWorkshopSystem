package com.example.CarsWorkshopSystem.model;

import com.example.CarsWorkshopSystem.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workers")
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private LocalDate dateOfStartJob;
    private Double salary;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "workers_roles",
            joinColumns = {@JoinColumn(name = "worker_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "worker_role_id",referencedColumnName = "id")})
    private List<WorkerRole> workerRoles = new ArrayList<>();
    @OneToMany(mappedBy = "worker")
    private List<Protocol>protocols;
    @OneToOne(mappedBy = "manager")
    private CarRepairCenter managerCarRepairCenter;
    @ManyToMany(mappedBy = "workers")
    private Set<Task> tasks = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "car_repair_center_id")
    private CarRepairCenter workingCarRepairCenter;
    @OneToOne(mappedBy = "worker")
    private Account account;
    @Enumerated(EnumType.STRING)
    private Role role = Role.WORKER;


    public Worker(String name, String surname, String email, String phoneNumber, String password, LocalDate dateOfBirth, String address, LocalDate dateOfStartJob,Double salary) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.dateOfStartJob = dateOfStartJob;
        this.salary = salary;
    }
}
