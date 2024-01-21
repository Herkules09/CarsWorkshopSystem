package com.example.CarsWorkshopSystem.service;

import com.example.CarsWorkshopSystem.model.Client;
import com.example.CarsWorkshopSystem.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsService implements UserDetailsService {

    private ClientRepository clientRepository;

    public CustomClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);

        if(client !=null){
            return new org.springframework.security.core.userdetails.User(client.getEmail(),client.getPassword(),null);
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
