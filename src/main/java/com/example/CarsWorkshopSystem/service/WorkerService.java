package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.dto.ClientDto;
import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.model.Worker;

import java.util.List;

public interface WorkerService {

    void saveWorker(WorkerDto workerDto);
    Worker findByEmail(String email);
    List<WorkerDto> findAllWorkers();
    void deleteWorkerById(Long id);
}
