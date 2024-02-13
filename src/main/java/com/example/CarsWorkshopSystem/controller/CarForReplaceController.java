package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.model.CarForReplace;
import com.example.CarsWorkshopSystem.service.CarForReplaceService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarForReplaceController {

    private CarForReplaceService carForReplaceService;

    public CarForReplaceController(CarForReplaceService carForReplaceService) { this.carForReplaceService = carForReplaceService; }

    @GetMapping("/carForReplace")
    public List<CarForReplace> showAllCarForRent(){
        return carForReplaceService.findAllCarForReplace();
    }

    @PostMapping("/addCarForReplace")
    public String addCarForReplace(@RequestBody CarForReplace carForReplace){
        carForReplaceService.saveCarForReplace(carForReplace);
        return "redirect:/addCarForReplace?success";
    }

    @DeleteMapping("/deleteCarForReplace/{id}")
    public String deleteClient(@PathVariable("id")Long id,Model model){
        carForReplaceService.deleteCarForReplaceById(id);
        return "redirect:/carForRents";
    }

}