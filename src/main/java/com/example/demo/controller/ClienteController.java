package com.example.demo.controller;

import com.example.demo.dto.ClienteDto;
import com.example.demo.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@Valid @RequestBody ClienteDto clienteDto){
       return clienteService.salvar(clienteDto);
    }
}
