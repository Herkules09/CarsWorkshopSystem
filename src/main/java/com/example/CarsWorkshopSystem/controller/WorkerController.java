package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Worker;
import com.example.CarsWorkshopSystem.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("workers")
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
        WorkerDto worker = new WorkerDto();
        model.addAttribute("worker", worker);
        return "registerWorker";
    }

    @PostMapping("/registerWorker/save")
    public String registrationWorker(@Valid @ModelAttribute("worker") WorkerDto workerDTO, BindingResult result, Model model){
        Worker existingWorker = workerService.findByEmail(workerDTO.getEmail());

        if(existingWorker !=null && existingWorker.getEmail() !=null && !existingWorker.getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already an account registered with the same email");
        }

        if (result.hasErrors()){
            model.addAttribute("worker",workerDTO);
            return "/registerWorker";
        }

        workerService.saveWorker(workerDTO);
        return "redirect:/registerWorker?success";
    }


    @PostMapping("/addWorker")
    public String addWorker(){
        WorkerDto workerDto = new WorkerDto("Jarek","Taki","jark@gmail.com","123456789","4321",
                LocalDate.now(),"Karpacz 12");
        workerService.saveWorker(workerDto);
        return "redirect:/workers";
    }

    @GetMapping("")
    public String showAllWorkers(Model model){
        List<WorkerDto> workers=workerService.findAllWorkers();
        model.addAttribute("workers",workers);
        return "workers";
    }
}
