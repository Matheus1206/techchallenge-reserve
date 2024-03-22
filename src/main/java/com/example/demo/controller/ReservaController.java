package com.example.demo.controller;

import com.example.demo.dto.ReservaDto;
import com.example.demo.services.ReservaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @PostMapping
    public String reservar(@RequestBody @Valid ReservaDto reservaDto, @RequestParam String idRestaurante){
        return reservaService.validaReserva(reservaDto, idRestaurante);
    }
}
