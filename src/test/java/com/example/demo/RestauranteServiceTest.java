package com.example.demo;

import com.example.demo.dto.RestauranteDto;
import com.example.demo.model.HorarioFuncionamento;
import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import com.example.demo.repository.RestauranteRepository;
import com.example.demo.services.RestauranteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RestauranteServiceTest {
    @Mock
    private RestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteService restauranteService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarRestaurante(){
        Restaurante restaurante = new Restaurante("Teste Mockito", "SP", Arrays.asList(HorarioFuncionamento.JANTA), TipoCozinha.BRASILEIRA, 10);
        when(restauranteRepository.save(restaurante)).thenReturn(restaurante);
        ResponseEntity<RestauranteDto> responseEntity = restauranteService.cadastrar(new RestauranteDto(restaurante.getNome(), restaurante.getLocalizacao(), restaurante.getTipoCozinha().toString(), restaurante.getHorarioFuncionamento(), restaurante.getCapacidade()));
        assertEquals("Teste Mockito", Objects.requireNonNull(responseEntity.getBody()).nome());
    }

}
