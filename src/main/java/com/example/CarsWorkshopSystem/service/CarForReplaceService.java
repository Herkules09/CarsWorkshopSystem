package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.model.CarForReplace;

import java.util.List;

public interface CarForReplaceService {
    void saveCarForReplace(CarForReplace carForReplace);
    CarForReplace findByModel(String VIN);
    List<CarForReplace> findAllCarForReplace();
    void updateCarForReplace(CarForReplace carForReplace);
    void deleteCarForReplaceById(Long id);
    CarForReplace findById(Long id);
}