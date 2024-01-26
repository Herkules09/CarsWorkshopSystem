package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.model.Worker;
import com.example.CarsWorkshopSystem.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WorkerController {

    private WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    // handler method to handle login request
    @GetMapping("/loginWorker")
    public String loginWorker(){
        return "loginWorker";
    }



    @GetMapping("/registerWorker")
    public String showRegistrationFormForClients(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);
        return "registerWorker";
    }

    @PostMapping("/registerWorker/save")
    public String registrationWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult result, Model model){
        Worker existingWorker = workerService.findByEmail(worker.getEmail());

        if(existingWorker !=null && existingWorker.getEmail() !=null && !existingWorker.getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already an account registered with the same email");
        }

        if (result.hasErrors()){
            model.addAttribute("worker",worker);
            return "registerWorker";
        }

        workerService.saveWorker(worker);
        return "redirect:/registerWorker?success";
    }


    @PostMapping("/addWorker")
    public String addWorker(@ModelAttribute("worker")Worker worker){
       // Worker worker = new Worker("Jarek","Taki","jark@gmail.com","123456789","4321", LocalDate.of(1990,10,12),"Karpacz 12",LocalDate.now(),4000.0);
        workerService.saveWorker(worker);
        return "redirect:/workers";
    }


    @GetMapping("/workers/{id}")
    public Worker findWorkerById(@PathVariable("id") Long id){
        return workerService.findWorkerById(id);
    }


    @GetMapping("/workers")
    public String showAllWorkers(Model model){
        List<Worker> workers=workerService.findAllWorkers();
        model.addAttribute("workers",workers);
        return "workers";
    }
}
