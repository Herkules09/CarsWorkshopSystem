package com.example.CarsWorkshopSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String information;
    private LocalDate dateOfCreate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    public Protocol(String information, LocalDate dateOfCreate, Worker worker, Client client){
        this.information = information;
        this.dateOfCreate = dateOfCreate;
        this.worker = worker;
        this.client = client;

    }

}