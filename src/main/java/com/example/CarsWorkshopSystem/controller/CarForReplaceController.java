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
    public String showAllCarForRent(Model model){

        List<CarForReplace> carForReplace=carForReplaceService.findAllCarForReplace();
        model.addAttribute("carForReplace",carForReplace);
        return "carForReplace";
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