package com.example.CarsWorkshopSystem.service;


import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void saveClient(Client client);
    Client findByEmail(String email);
    List<Client> findAllClients();
    void updateClient(Client client);
    void deleteClientById(Long id);
    Client findById(Long id);
    Boolean isClientExist(Client client);

}
