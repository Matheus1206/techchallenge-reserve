package com.example.demo.controller;

import com.example.demo.dto.ReservaDto;
import com.example.demo.services.ReservaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @PostMapping
    public String reservar(@RequestBody @Valid ReservaDto reservaDto){
        return reservaService.validaReserva(reservaDto);
    }
}
