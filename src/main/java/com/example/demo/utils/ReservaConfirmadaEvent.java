package com.example.demo.utils;

import com.example.demo.model.Reserva;
import org.springframework.context.ApplicationEvent;

public class ReservaConfirmadaEvent extends ApplicationEvent {

    private final Reserva reserva;

    public ReservaConfirmadaEvent(Object source, Reserva reserva) {
        super(source);
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }
}
