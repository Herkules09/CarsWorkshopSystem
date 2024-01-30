package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.model.CarForRent;
import com.example.CarsWorkshopSystem.repository.CarForRentRepository;
import com.example.CarsWorkshopSystem.service.CarForRentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarForRentServiceImpl implements CarForRentService {

    private CarForRentRepository carForRentRepository;

    public CarForRentServiceImpl(CarForRentRepository carForRentRepository) {
        this.carForRentRepository = carForRentRepository;

    }

    @Override
    public void saveCarForRent(CarForRent carForRent){
        carForRentRepository.save(carForRent);
    }

    @Override
    public CarForRent findByModel(String model) {
        return carForRentRepository.findByModel(model);
    }

    @Override
    public List<CarForRent> findAllCarForRents(){
        return carForRentRepository.findAll();
    }

    @Override
    public void updateCarForRents(CarForRent carForRent){
        carForRentRepository.save(carForRent);
    }

    @Override
    public void deleteCarForRentsById(Long id){
        carForRentRepository.deleteById(id);
    }

    @Override
    public CarForRent findById(Long id) {
        return carForRentRepository.findById(id).get();
    }
}
