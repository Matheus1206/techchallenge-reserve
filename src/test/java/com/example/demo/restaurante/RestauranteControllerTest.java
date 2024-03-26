package com.example.demo.restaurante;

import com.example.demo.dto.RestauranteDto;
import com.example.demo.model.HorarioFuncionamento;
import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import com.example.demo.services.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestauranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestauranteService restauranteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCadastrarRestauranteController() throws Exception {
        RestauranteDto restauranteDto = new RestauranteDto("Teste", "SP", TipoCozinha.BRASILEIRA.toString(), Arrays.asList(HorarioFuncionamento.ALMOCO), 34);
        ResponseEntity<RestauranteDto> responseEntity = ResponseEntity.ok(restauranteDto);
        given(restauranteService.cadastrar(any(RestauranteDto.class))).willReturn(responseEntity);

        mockMvc.perform(post("/api/v1/restaurante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restauranteDto)))
                .andExpect(status().isOk());
    }

    @Test
    void testTodosRestauranteController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurante/todos")).andExpect(status().isOk());
    }

    @Test
    void testPesquisaRestauranteController() throws Exception {
        List<Restaurante> lista = new ArrayList<>();
        lista.add(new Restaurante("Teste", "SP", Arrays.asList(HorarioFuncionamento.JANTA), TipoCozinha.BRASILEIRA, 35));
        given(restauranteService.pesquisaPorParametro("nome", "Teste")).willReturn(lista);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurante/pesquisa")
                .param("parametro", "nome")
                .param("valor", "Teste"))
                .andExpect(status().isOk());
    }
}
