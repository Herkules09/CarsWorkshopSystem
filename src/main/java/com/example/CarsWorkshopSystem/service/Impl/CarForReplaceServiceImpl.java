package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.model.CarForReplace;
import com.example.CarsWorkshopSystem.repository.CarForReplaceRepository;
import com.example.CarsWorkshopSystem.service.CarForReplaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarForReplaceServiceImpl implements CarForReplaceService {

    private CarForReplaceRepository carForReplaceRepository;

    public CarForReplaceServiceImpl(CarForReplaceRepository carForReplaceRepository){
        this.carForReplaceRepository = carForReplaceRepository;
    }

    @Override
    public void saveCarForReplace(CarForReplace carForReplace){
        carForReplaceRepository.save(carForReplace);
    }

    @Override
    public CarForReplace findByModel(String model){
        return carForReplaceRepository.findByModel(model);
    }

    @Override
    public List<CarForReplace> findAllCarForReplace(){
        return carForReplaceRepository.findAll();
    }

    @Override
    public void updateCarForReplace(CarForReplace carForReplace){
        carForReplaceRepository.save(carForReplace);
    }

    @Override
    public void deleteCarForReplaceById(Long id)
    {
        carForReplaceRepository.deleteById(id);
    }

    @Override
    public CarForReplace findById(Long id){
        return carForReplaceRepository.findById(id).get();
    }
}