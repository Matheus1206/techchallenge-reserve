package com.example.demo.estabelecimento;

import com.example.demo.model.HorarioFuncionamento;
import com.example.demo.model.Reserva;
import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.RestauranteRepository;
import com.example.demo.services.EstabelecimentoService;
import com.example.demo.utils.ReservaConfirmadaEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EstabelecimentoServiceTest {

    @Mock
    private RestauranteRepository estabelecimentoRepository;

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private EstabelecimentoService estabelecimentoService;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    private final Reserva reserva = new Reserva("Matheus", 2, LocalDateTime.now(), "teste", new Restaurante());
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAvaliarReserva(){
        when(reservaRepository.findById("1234")).thenReturn(Optional.of(reserva));
        estabelecimentoService.avaliarReserva("1234");
        verify(eventPublisher, times(1)).publishEvent(any(ReservaConfirmadaEvent.class));
    }

    @Test
    void testMudarStatusReserva(){
       Reserva reserva = new Reserva("Teste", 45, LocalDateTime.now(), "teste", new Restaurante());
       when(reservaRepository.findById("1234")).thenReturn(Optional.of(reserva));
       Reserva reservaAlterada = estabelecimentoService.mudarStatusReserva("1234");
       assertFalse(reservaAlterada.getStatusReserva());
    }

    @Test
    void testListarReservas(){
        List<Reserva> lista = new ArrayList<>();
        lista.add(new Reserva("Teste", 45, LocalDateTime.now(), "teste", new Restaurante("Restaurante Teste", "SP", Arrays.asList(HorarioFuncionamento.JANTA), TipoCozinha.BRASILEIRA, 34)));
        when(reservaRepository.findReservaRestauranteNome("Restaurante Teste")).thenReturn(lista);
        List<Reserva> reservaList = estabelecimentoService.listarReservas("Restaurante Teste");
        assertEquals("Teste", reservaList.get(0).getEmailCliente());
    }
}
