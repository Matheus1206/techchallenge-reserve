package com.example.demo.services;

import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.utils.ReservaConfirmadaEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstabelecimentoService {

    private final ReservaRepository reservaRepository;

    private final ApplicationEventPublisher eventPublisher;

    public EstabelecimentoService(ReservaRepository reservaRepository, ApplicationEventPublisher eventPublisher){
        this.reservaRepository = reservaRepository;
        this.eventPublisher = eventPublisher;
    }


    public List<Reserva> listarReservas(String nomeRestaurante) {
        return reservaRepository.findReservaRestauranteNome(nomeRestaurante);
    }
    @Transactional
    public Reserva mudarStatusReserva(String idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
        reserva.setStatusReserva();
        reservaRepository.save(reserva);
        return reserva;
    }

    public void avaliarReserva(String idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
        eventPublisher.publishEvent(new ReservaConfirmadaEvent(this, reserva));
    }
}
