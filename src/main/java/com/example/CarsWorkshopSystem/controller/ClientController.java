package com.example.CarsWorkshopSystem.controller;

import ch.qos.logback.core.net.server.ClientVisitor;
import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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
    public String registrationClient(@Valid @RequestBody Client client, BindingResult result, Model model){
        Client existingClient = clientService.findByEmail(client.getEmail());

        if(existingClient !=null && existingClient.getEmail() !=null && !existingClient.getEmail().isEmpty()){
            result.rejectValue("email",null,"There is already an account registered with the same email");
        }

        if (result.hasErrors()){
            model.addAttribute("client",client);
            return "registerClient";
        }
        clientService.saveClient(client);
        return "redirect:/registerClient?success";
    }

    @GetMapping("/clients")
    public String showAllClients(Model model){
        List<Client> clients=clientService.findAllClients();
        model.addAttribute("clients",clients);
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public Client findClientById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @GetMapping("/editClient/{clientId}")
    public String showEditForm(@PathVariable Long clientId, Model model) {

        Client client = clientService.findById(clientId);
        model.addAttribute("client", client);

        return "editClient"; // Nazwa widoku dla formularza edycji
    }

    @PostMapping("/editClient/save")
    public String saveEditedClient(@Valid @ModelAttribute("client") Client editedClient, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", editedClient);
            return "editClient";
        }
        clientService.updateClient(editedClient);

        return "redirect:/clients";
    }


    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id")Long id,Model model){
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }


    @PostMapping("/addClient")
    public String addClient(@RequestBody Client client){
        clientService.saveClient(client);
        return "TEST";
    }


    private ClientDto convertToDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setSurname(client.getSurname());
        clientDto.setEmail(client.getEmail());
        clientDto.setPassword(client.getPassword());
        clientDto.setAddress(client.getAddress());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setProtocols(client.getProtocols());
        clientDto.setHistoryOfOrders(client.getHistoryOfOrders());

        return clientDto;
    }

}