package com.example.CarsWorkshopSystem.controller;

import com.example.CarsWorkshopSystem.model.Protocol;
import com.example.CarsWorkshopSystem.service.ProtocolService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProtocolController {
    private ProtocolService protocolService;

    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping("/protocol")
    public String showAllProtocol(Model model){
        List<Protocol> protocol=protocolService.findAllProtocol();
        model.addAttribute("protocol",protocol);
        return "protocol";
    }

    @PostMapping("/addProtocol")
    public String addProtocol(@RequestBody Protocol protocol){
        protocolService.saveProtocol(protocol);
        return "redirect:/protocol?success";
    }

    @DeleteMapping("/deleteProtocol/{id}")
    public String deleteProtocol(@PathVariable("id")Long id,Model model){
        protocolService.deleteProtocol(id);
        return "redirect:/protocol";
    }
}