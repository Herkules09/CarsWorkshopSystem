package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.model.CarForRepair;
import com.example.CarsWorkshopSystem.repository.CarForRepairRepository;
import com.example.CarsWorkshopSystem.service.CarForRepairService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarForRepairServiceImpl implements CarForRepairService {

    private CarForRepairRepository carForRepairRepository;

    public CarForRepairServiceImpl(CarForRepairRepository carForRepairRepository) {
        this.carForRepairRepository = carForRepairRepository;

    }

    @Override
    public void saveCarForRepair(CarForRepair carForRepair){
        carForRepairRepository.save(carForRepair);
    }

    @Override
    public CarForRepair findByVIN(String VIN){
        return carForRepairRepository.findByVIN(VIN);
    }

    @Override
    public List<CarForRepair> findAllCarForRepair(){
        return carForRepairRepository.findAll();
    }

    @Override
    public void updateCarForRepair(CarForRepair carForRepair){
        carForRepairRepository.save(carForRepair);
    }

    @Override
    public void deleteCarForRepairById(Long id)
    {
        carForRepairRepository.deleteById(id);
    }

    @Override
    public CarForRepair findById(Long id){
        return carForRepairRepository.findById(id).get();
    }
}
