package com.example.CarsWorkshopSystem.service.Impl;

import com.example.CarsWorkshopSystem.dto.WorkerDto;
import com.example.CarsWorkshopSystem.model.Worker;
import com.example.CarsWorkshopSystem.model.WorkerRole;
import com.example.CarsWorkshopSystem.repository.WorkerRepository;
import com.example.CarsWorkshopSystem.repository.WorkerRoleRepository;
import com.example.CarsWorkshopSystem.service.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerRoleRepository workerRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public WorkerServiceImpl(WorkerRepository workerRepository, WorkerRoleRepository workerRoleRepository, PasswordEncoder passwordEncoder) {
        this.workerRepository = workerRepository;
        this.workerRoleRepository = workerRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveWorker(WorkerDto workerDto) {
        Worker newWorker = new Worker();
        newWorker.setName(workerDto.getName());
        newWorker.setSurname(workerDto.getSurname());
        newWorker.setEmail(workerDto.getEmail());
        newWorker.setPhoneNumber(workerDto.getPhoneNumber());
        newWorker.setDateOfBirth(workerDto.getDateOfBirth());
        newWorker.setAddress(workerDto.getAddress());
        newWorker.setDateOfStartJob(workerDto.getDateOfStartJob());
        newWorker.setSalary(workerDto.getSalary());
        newWorker.setPassword(passwordEncoder.encode(workerDto.getPassword()));

        WorkerRole adminRole = workerRoleRepository.findByName("ADMIN");
        if (adminRole == null) {
            adminRole = createAdminRole();
        }
        newWorker.setWorkerRoles(Arrays.asList(adminRole));
        workerRepository.save(newWorker);

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
    public List<WorkerDto> findAllWorkers() {
        List<Worker> workers = workerRepository.findAll();
        return workers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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

