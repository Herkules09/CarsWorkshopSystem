package com.example.CarsWorkshopSystem.repository;

import com.example.CarsWorkshopSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByEmail(String email);
}
