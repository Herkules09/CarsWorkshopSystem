package com.example.CarsWorkshopSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
