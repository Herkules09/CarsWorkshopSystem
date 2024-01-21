package com.example.CarsWorkshopSystem.service.Impl;


import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.repository.ClientRepository;
import com.example.CarsWorkshopSystem.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveClient(ClientDto clientDTO) {
        Client client= new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setDateOfBirth(clientDTO.getDateOfBirth());
        client.setAddress(clientDTO.getAddress());
        client.setHistoryOfOrders(clientDTO.getHistoryOfOrders());
        client.setProtocols(clientDTO.getProtocols());
        client.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
        clientRepository.save(client);

    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<ClientDto> findAllClients() {
        List<Client>clients = clientRepository.findAll();
        return clients.stream().map((client) -> mapToClientDto(client)).collect(Collectors.toList());
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
