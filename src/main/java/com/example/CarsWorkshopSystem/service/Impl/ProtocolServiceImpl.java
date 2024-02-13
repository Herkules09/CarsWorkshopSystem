package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.repository.ProtocolRepository;
import com.example.CarsWorkshopSystem.service.ProtocolService;
import com.example.CarsWorkshopSystem.model.Protocol;
import com.example.CarsWorkshopSystem.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository protocolRepository;

    public ProtocolServiceImpl(ProtocolRepository protocolRepository){
        this.protocolRepository = protocolRepository;
    }
    @Override
    public void saveProtocol(Protocol protocol) {
        protocolRepository.save(protocol);
    }

    @Override
    public Protocol findByClient(Client client) {
        return protocolRepository.findByClient(client);
    }
    @Override
    public Protocol findByWorker(Worker worker){
        return protocolRepository.findByWorker(worker);
    }
    @Override
    public List<Protocol> findAllProtocol(){
        return protocolRepository.findAll();
    }
    @Override
    public void updateProtocol(Protocol protocol) {
        protocolRepository.save(protocol);
    }
    @Override
    public void deleteProtocol(Long id){
        protocolRepository.deleteById(id);
    }
    @Override
    public Protocol findById(Long id){
        return protocolRepository.findById(id).get();
    }
}