package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Worker findByEmail(String email);
}
