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

@Controller
@RequestMapping("clients")
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

    @GetMapping("")
    public String showAllClients(Model model){
        List<ClientDto> clients=clientService.findAllClients();
        model.addAttribute("clients",clients);
        return "clients";
    }

    @GetMapping("/{id}")
    public Client findClientById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @GetMapping("/editClient/{clientId}")
    public String showEditForm(@PathVariable Long clientId, Model model) {

        Client client = clientService.findById(clientId);
        ClientDto clientDto=convertToDto(client);
        model.addAttribute("client", clientDto);

        return "editClient"; // Nazwa widoku dla formularza edycji
    }

    @PostMapping("/editClient/save")
    public String saveEditedClient(@Valid @ModelAttribute("client") ClientDto editedClientDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", editedClientDTO);
            return "/editClient";
        }
        clientService.updateClient(editedClientDTO);

        return "redirect:/clients";
    }


    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id")Long id,Model model){
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }

    @PostMapping("/addClient")
    public String addClient(){
        Client client = new Client("Adam","Kowalski","adam@wp.pl","123123123", LocalDate.now(),"Katowice 12");
        clientService.saveClient(convertToDto(client));
        return "redirect:/clients";
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