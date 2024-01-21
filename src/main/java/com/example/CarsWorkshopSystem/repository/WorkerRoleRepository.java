package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.WorkerRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRoleRepository extends JpaRepository<WorkerRole,Long> {

    WorkerRole findByName(String name);
}
