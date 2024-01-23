package com.example.CarsWorkshopSystem.dto;


import com.example.CarsWorkshopSystem.model.Protocol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientDto {


    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private LocalDate dateOfBirth;
    @NotEmpty
    private String address;
    private String historyOfOrders;
    private List<Protocol> protocols;

    public ClientDto(String name, String surname, String email, String password, String phoneNumber, LocalDate dateOfBirth, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }



}
