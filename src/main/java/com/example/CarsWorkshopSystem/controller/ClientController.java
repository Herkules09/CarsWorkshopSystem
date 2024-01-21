package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    // handler method to handle login request
    @GetMapping("/loginClient")
    public String loginClient(){
        return "loginClient";
    }



    @GetMapping("/registerClient")
    public String showRegistrationFormForClients(Model model) {
        ClientDto client = new ClientDto();
        model.addAttribute("client", client);
        return "registerClient";
    }

    @PostMapping("/registerClient/save")
    public String registrationClient(@Valid @ModelAttribute("client") ClientDto clientDTO, BindingResult result, Model model){
        Client existingClient = clientService.findByEmail(clientDTO.getEmail());

        if(existingClient !=null && existingClient.getEmail() !=null && !existingClient.getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already an account registered with the same email");
        }

        if (result.hasErrors()){
            model.addAttribute("client",clientDTO);
            return "/registerClient";
        }

        clientService.saveClient(clientDTO);
        return "redirect:/registerClient?success";
    }

    @GetMapping("/clients")
    public String clients(Model model){
        List<ClientDto> clients=clientService.findAllClients();
        model.addAttribute("clients",clients);
        return "clients";
    }

}