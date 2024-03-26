package com.example.demo.reserva;

import com.example.demo.dto.ReservaDto;
import com.example.demo.model.*;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.RestauranteRepository;
import com.example.demo.services.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReservaServiceTest {
    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private RestauranteRepository restauranteRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testValidarUmaReservaService(){
        ReservaDto reservaDto = new ReservaDto("teste@teste.com", 30, LocalDateTime.now().plusHours(2), "teste");
        Restaurante restaurante = new Restaurante("Teste Restaurante", "SP", Arrays.asList(HorarioFuncionamento.JANTA), TipoCozinha.BRASILEIRA, 30);
        when(restauranteRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(restaurante));
        Cliente cliente = new Cliente("Matheus", "teste@teste.com");
        when(clienteRepository.findByEmail(reservaDto.emailCliente())).thenReturn(Optional.ofNullable(cliente));
        Reserva reserva = new Reserva(reservaDto.emailCliente(), reservaDto.lugares(), reservaDto.dataReserva(), reservaDto.observacao(),restaurante);
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
        Reserva validaedReserva = reservaService.validaReserva(reservaDto, "Teste Restaurante");
        assertEquals("teste@teste.com", validaedReserva.getEmailCliente());
    }

}
