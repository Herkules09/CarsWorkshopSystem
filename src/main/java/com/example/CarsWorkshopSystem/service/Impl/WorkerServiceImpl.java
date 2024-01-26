package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Worker;
import com.example.CarsWorkshopSystem.model.WorkerRole;
import com.example.CarsWorkshopSystem.repository.WorkerRepository;
import com.example.CarsWorkshopSystem.repository.WorkerRoleRepository;
import com.example.CarsWorkshopSystem.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerRoleRepository workerRoleRepository;


    public WorkerServiceImpl(WorkerRepository workerRepository, WorkerRoleRepository workerRoleRepository) {
        this.workerRepository = workerRepository;
        this.workerRoleRepository = workerRoleRepository;

    }

    @Override
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    private WorkerRole createAdminRole() {
        WorkerRole adminRole = new WorkerRole();
        adminRole.setName("ADMIN");
        return workerRoleRepository.save(adminRole);
    }

    @Override
    public Worker findByEmail(String email) {
        return workerRepository.findByEmail(email);
    }

    @Override
    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).get();
    }

    @Override
    public void deleteWorkerById(Long id) {
        if(workerRepository.existsById(id)){
            workerRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Worker with id: "+id+" not found");
        }
    }

    private WorkerDto convertToDto(Worker worker) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setName(worker.getName());
        workerDto.setSurname(worker.getSurname());
        workerDto.setEmail(worker.getEmail());
        workerDto.setPhoneNumber(worker.getPhoneNumber());
        workerDto.setPassword(worker.getPassword());
        workerDto.setDateOfBirth(worker.getDateOfBirth());
        workerDto.setAddress(worker.getAddress());
        workerDto.setDateOfStartJob(worker.getDateOfStartJob());
        workerDto.setSalary(worker.getSalary());
        workerDto.setWorkerRoles(worker.getWorkerRoles());
        return workerDto;
    }
}

