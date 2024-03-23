package com.example.demo.utils;

import com.example.demo.model.Reserva;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ReservaConfirmadaListener {

    @EventListener
    public void handleReservaConfirmada(ReservaConfirmadaEvent reservaConfirmadaEvent){
        Reserva reserva = reservaConfirmadaEvent.getReserva();
        log.info("Sending confirmation email to: " + reserva.getEmailCliente());
    }
}
