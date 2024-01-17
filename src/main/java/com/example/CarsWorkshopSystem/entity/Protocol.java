package com.example.CarsWorkshopSystem.entity;

import jakarta.persistence.*;

@Entity
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String information;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
