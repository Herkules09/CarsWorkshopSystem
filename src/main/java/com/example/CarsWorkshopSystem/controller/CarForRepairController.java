package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.model.CarForRepair;
import com.example.CarsWorkshopSystem.service.CarForRepairService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarForRepairController {

    private CarForRepairService carForRepairService;

    public CarForRepairController(CarForRepairService carForRepairService) {
        this.carForRepairService = carForRepairService;
    }

    @GetMapping("/carForRepair")
    public String showAllCarForRent(Model model){
        List<CarForRepair> carForRepair=carForRepairService.findAllCarForRepair();
        model.addAttribute("carForRepair",carForRepair);
        return "carForRepair";
    }

    @PostMapping("/addCarForRepair")
    public String addCarForRepair(@RequestBody CarForRepair carForRepair){
        carForRepairService.saveCarForRepair(carForRepair);
        return "redirect:/addCarForRepair?success";
    }

    @DeleteMapping("/deleteCarForRepair/{id}")
    public String deleteClient(@PathVariable("id")Long id,Model model){
        carForRepairService.deleteCarForRepairById(id);
        return "redirect:/carForRepair";
    }
}
