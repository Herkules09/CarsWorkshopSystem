package com.example.CarsWorkshopSystem.service.Impl;


import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.repository.ClientRepository;
import com.example.CarsWorkshopSystem.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);

    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Client> findAllClients() {
       return clientRepository.findAll();
    }


    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }


    @Override
    public Boolean isClientExist(Client client) {
        Client existingClient= clientRepository.findByEmail(client.getEmail());
        return existingClient != null;
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    private ClientDto mapToClientDto(Client client){
        ClientDto clientDTO = new ClientDto();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setEmail(clientDTO.getEmail());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setDateOfBirth(client.getDateOfBirth());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setHistoryOfOrders(client.getHistoryOfOrders());
        clientDTO.setProtocols(client.getProtocols());
        return clientDTO;
    }


}
