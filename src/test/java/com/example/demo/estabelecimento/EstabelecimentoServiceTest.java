package com.example.demo.estabelecimento;

import com.example.demo.model.Reserva;
import com.example.demo.model.Restaurante;
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
import java.util.Optional;

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
}
