package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.model.Protocol;
import com.example.CarsWorkshopSystem.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol,Long> {
    Protocol findByClient(Client client);
    Protocol findByWorker(Worker worker);
}