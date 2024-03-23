package com.example.demo.controller;

import com.example.demo.model.Reserva;
import com.example.demo.services.EstabelecimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estabelecimento")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    public EstabelecimentoController(EstabelecimentoService estabelecimentoService){
        this.estabelecimentoService = estabelecimentoService;
    }

    @GetMapping
    public List<Reserva> listarTodasAsReservas(@RequestParam String nomeRestaurante){
        return estabelecimentoService.listarReservas(nomeRestaurante);
    }

    @PostMapping
    public Reserva mudarStatus(@RequestParam String idReserva){
        return estabelecimentoService.mudarStatusReserva(idReserva);
    }
}
