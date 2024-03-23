package com.example.demo.services;

import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstabelecimentoService {

    private final ReservaRepository reservaRepository;

    public EstabelecimentoService(ReservaRepository reservaRepository){
        this.reservaRepository = reservaRepository;
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
}
