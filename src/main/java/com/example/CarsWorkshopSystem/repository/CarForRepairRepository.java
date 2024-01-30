package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.CarForRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarForRepairRepository extends JpaRepository<CarForRepair,Long> {

    CarForRepair findByVIN(String VIN);
}
