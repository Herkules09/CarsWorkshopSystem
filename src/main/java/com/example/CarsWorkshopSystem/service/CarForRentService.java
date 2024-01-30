package com.example.CarsWorkshopSystem.service;


import com.example.CarsWorkshopSystem.model.CarForRent;

import java.util.List;

public interface CarForRentService  {

    void saveCarForRent(CarForRent carForRent);
    CarForRent findByModel(String model);
    List<CarForRent> findAllCarForRents();
    void updateCarForRents(CarForRent carForRent);
    void deleteCarForRentsById(Long id);
    CarForRent findById(Long id);
}
