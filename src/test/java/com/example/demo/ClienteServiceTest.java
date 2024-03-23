package com.example.demo;

import com.example.demo.dto.ClienteDto;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarCliente(){
        Cliente cliente = new Cliente("teste", "teste@teste.com");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        ResponseEntity<ClienteDto> salvar = clienteService.salvar(new ClienteDto(cliente.getNome(), cliente.getEmail()));
        assertEquals("teste", Objects.requireNonNull(salvar.getBody()).nome());

    }

}
