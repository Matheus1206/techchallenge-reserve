package com.example.demo.services;

import com.example.demo.dto.ClienteDto;
import com.example.demo.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<ClienteDto> salvar(ClienteDto clienteDto) {
        clienteRepository.save(clienteDto.toModel());
        return ResponseEntity.ok(clienteDto);
    }
}
