package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.model.CarForRepair;

import java.util.List;

public interface CarForRepairService {

    void saveCarForRepair(CarForRepair carForRepair);
    CarForRepair findByVIN(String VIN);
    List<CarForRepair> findAllCarForRepair();
    void updateCarForRepair(CarForRepair carForRepair);
    void deleteCarForRepairById(Long id);
    CarForRepair findById(Long id);
}
