package com.example.CarsWorkshopSystem.controller;


import com.example.CarsWorkshopSystem.model.CarForRent;
import com.example.CarsWorkshopSystem.service.CarForRentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarForRentController {

    private CarForRentService carForRentService;

    public CarForRentController(CarForRentService carForRentService) {
        this.carForRentService = carForRentService;
    }

    @GetMapping("/carForRents")
    public String showAllCarForRent(Model model){

        List<CarForRent> carForRents=carForRentService.findAllCarForRents();
        model.addAttribute("carForRents",carForRents);
        return "carForRents";
    }

    @PostMapping("/addCarForRent")
    public String addCarForRent(@RequestBody CarForRent carForRent){
        carForRentService.saveCarForRent(carForRent);
        return "redirect:/addCarForRent?success";
    }

    @DeleteMapping("/deleteCarForRent/{id}")
    public String deleteClient(@PathVariable("id")Long id,Model model){
        carForRentService.deleteCarForRentsById(id);
        return "redirect:/carForRents";
    }
}
