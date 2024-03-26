package com.example.demo.estabelecimento;

import com.example.demo.model.Reserva;
import com.example.demo.model.Restaurante;
import com.example.demo.services.EstabelecimentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EstabelecimentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstabelecimentoService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testMudarStatus() throws Exception {
        Reserva reserva = new Reserva("Matheus", 25, LocalDateTime.now(), "teste", new Restaurante());
        given(clienteService.mudarStatusReserva(any(String.class))).willReturn(reserva);

        mockMvc.perform(post("/api/v1/estabelecimento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("idReserva", "1234"))
                .andExpect(status().isOk());
    }

    @Test
    void testListarTodasAsReservas() throws Exception {
        List<Reserva> lista = new ArrayList<>();
        Reserva reserva = new Reserva("Matheus", 25, LocalDateTime.now(), "teste", new Restaurante());
        lista.add(reserva);
        given(clienteService.listarReservas(any(String.class))).willReturn(lista);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/estabelecimento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("nomeRestaurante", "teste"))
                .andExpect(status().isOk());
    }

    @Test
    void testAvaliarReservas() throws Exception {
        List<Reserva> lista = new ArrayList<>();
        Reserva reserva = new Reserva("Matheus", 25, LocalDateTime.now(), "teste", new Restaurante());
        lista.add(reserva);
        given(clienteService.listarReservas(any(String.class))).willReturn(lista);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/estabelecimento/avaliar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("idReserva", "1234"))
                .andExpect(status().isOk());
    }
}
