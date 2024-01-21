package com.example.CarsWorkshopSystem.dto;

import com.example.CarsWorkshopSystem.model.Worker;
import com.example.CarsWorkshopSystem.model.WorkerRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDate dateOfStartJob;
    private Double salary;
    private List<WorkerRole> workerRoles = new ArrayList<>();



    public Worker toWorker() {
        Worker worker = new Worker();
        worker.setName(this.name);
        worker.setSurname(this.surname);
        worker.setEmail(this.email);
        worker.setPhoneNumber(this.phoneNumber);
        worker.setPassword(this.password);
        worker.setDateOfBirth(this.dateOfBirth);
        worker.setAddress(this.address);
        worker.setDateOfStartJob(this.dateOfStartJob);
        worker.setSalary(this.salary);
        worker.setWorkerRoles(this.workerRoles);

        return worker;
    }


    public Worker updateWorker(Worker existingWorker) {
        existingWorker.setName(this.name);
        existingWorker.setSurname(this.surname);
        existingWorker.setEmail(this.email);
        existingWorker.setPhoneNumber(this.phoneNumber);
        existingWorker.setPassword(this.password);
        existingWorker.setDateOfBirth(this.dateOfBirth);
        existingWorker.setAddress(this.address);
        existingWorker.setDateOfStartJob(this.dateOfStartJob);
        existingWorker.setSalary(this.salary);
        existingWorker.setWorkerRoles(this.workerRoles);
        return existingWorker;
    }
}
