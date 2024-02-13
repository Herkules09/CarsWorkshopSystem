package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.CarForReplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarForReplaceRepository extends JpaRepository<CarForReplace,Long> {
    CarForReplace findByModel(String model);
}
