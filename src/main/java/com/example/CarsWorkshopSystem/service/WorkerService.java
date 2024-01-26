package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.model.Worker;

import java.util.List;

public interface WorkerService {

    void saveWorker(Worker worker);
    Worker findByEmail(String email);
    List<Worker> findAllWorkers();
    void deleteWorkerById(Long id);
    Worker findWorkerById(Long id);
}
