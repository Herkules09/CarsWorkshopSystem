package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.model.Protocol;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.model.Worker;

import java.util.List;

public interface ProtocolService {
    void saveProtocol(Protocol protocol);
    Protocol findByClient(Client client);
    Protocol findByWorker(Worker worker);
    List<Protocol> findAllProtocol();
    void updateProtocol(Protocol protocol);
    void deleteProtocol(Long id);
    Protocol findById(Long id);
}