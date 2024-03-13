package com.example.demo.services;

import com.example.demo.dto.ReservaDto;
import com.example.demo.model.Cliente;
import com.example.demo.model.Reserva;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ReservaRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {

    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    public ReservaService(ClienteRepository clienteRepository, ReservaRepository reservaRepository) {
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
    }

    @SneakyThrows
    public String validaReserva(ReservaDto reservaDto) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(reservaDto.emailCliente());
        if(cliente.isEmpty()){
            throw new ClassNotFoundException();
        }
        Reserva save = reservaRepository.save(new Reserva(cliente.get().getEmail(), reservaDto.mesa(), reservaDto.lugares(), reservaDto.dataReserva(), reservaDto.observacao()));
        return save.toString();
    }
}
