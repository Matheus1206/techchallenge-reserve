package com.example.demo.services;

import com.example.demo.dto.ReservaDto;
import com.example.demo.handler.QuantidadeDeMesaDisponivelException;
import com.example.demo.model.Cliente;
import com.example.demo.model.Reserva;
import com.example.demo.model.Restaurante;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.RestauranteRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {

    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    private final RestauranteRepository restauranteRepository;

    public ReservaService(ClienteRepository clienteRepository, ReservaRepository reservaRepository, RestauranteRepository restauranteRepository) {
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
        this.restauranteRepository = restauranteRepository;
    }

    @SneakyThrows
    public String validaReserva(ReservaDto reservaDto, String idRestaurante) {
        Restaurante restaurante = restauranteRepository.findById(idRestaurante).orElseThrow();
        Optional<Cliente> cliente = clienteRepository.findByEmail(reservaDto.emailCliente());
        if(cliente.isEmpty()){
            throw new ClassNotFoundException();
        }
        if(restaurante.getCapacidade() >= 1){
            restaurante.setCapacidade(restaurante.getCapacidade() - 1);
            restauranteRepository.save(restaurante);
            Reserva save = reservaRepository.save(new Reserva(cliente.get().getEmail(), reservaDto.lugares(), reservaDto.dataReserva(), reservaDto.observacao(), new Restaurante(restaurante.getId(), restaurante.getNome(), restaurante.getLocalizacao(), restaurante.getTipoCozinha(), restaurante.getHorarioFuncionamento(), restaurante.getCapacidade())));
            return save.toString();
        } else {
            throw new QuantidadeDeMesaDisponivelException();
        }
    }
}
