package com.example.CarsWorkshopSystem.service;


import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void saveClient(ClientDto clientDTO);
    Client findByEmail(String email);
    List<ClientDto> findAllClients();
    void updateClient(ClientDto clientDto);
    void deleteClientById(Long id);
    Client findById(Long id);

}
