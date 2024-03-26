package com.example.demo.reserva;

import com.example.demo.dto.ReservaDto;
import com.example.demo.model.Reserva;
import com.example.demo.services.ReservaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReservaService reservaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testValidarReservaControllerPassandoUmaQuantidadeMaiorDeLugares() throws Exception {
        ReservaDto reservaDto = new ReservaDto("Teste Cliente", 30, LocalDateTime.now().plusHours(2), "teste");
        Reserva reserva = new Reserva();
        given(reservaService.validaReserva(any(ReservaDto.class), any(String.class))).willReturn(reserva);
        mockMvc.perform(post("/api/v1/reserva")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reservaDto)))
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    void testValidarReservaControllerPassandoUmaDataNoPassado() throws Exception {
        ReservaDto reservaDto = new ReservaDto("Teste Cliente", 30, LocalDateTime.now().minusDays(3), "teste");
        Reserva reserva = new Reserva();
        given(reservaService.validaReserva(any(ReservaDto.class), any(String.class))).willReturn(reserva);
        mockMvc.perform(post("/api/v1/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDto)))
                .andExpect(status().is4xxClientError())
        ;
    }

    @Test
    void testValidarReservaControllerComOsParametrosValidos() throws Exception {
        ReservaDto reservaDto = new ReservaDto("Teste Cliente", 2, LocalDateTime.now().plusDays(3), "teste");
        Reserva reserva = new Reserva();
        given(reservaService.validaReserva(any(ReservaDto.class), any(String.class))).willReturn(reserva);
        mockMvc.perform(post("/api/v1/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("idRestaurante", "124")
                        .content(objectMapper.writeValueAsString(reservaDto)))
                .andExpect(status().isOk())
        ;
    }

}
