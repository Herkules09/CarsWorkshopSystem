package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.CarForRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarForRentRepository extends JpaRepository<CarForRent,Long> {

    CarForRent findByModel(String model);
}
