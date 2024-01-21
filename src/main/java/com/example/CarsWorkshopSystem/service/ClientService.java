package com.example.CarsWorkshopSystem.service;


import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;

import java.util.List;

public interface ClientService {

    void saveClient(ClientDto clientDTO);
    Client findByEmail(String email);
    List<ClientDto> findAllClients();
}
