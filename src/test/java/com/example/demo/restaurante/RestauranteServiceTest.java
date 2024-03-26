package com.example.demo.restaurante;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RestauranteServiceTest {
    @Mock
    private RestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteService restauranteService;

    private final Restaurante restaurante = new Restaurante("Teste Mockito", "SP", Arrays.asList(HorarioFuncionamento.JANTA), TipoCozinha.BRASILEIRA, 10);

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarRestaurante(){
        var restauranteNulo = restauranteService.cadastrar(new RestauranteDto(null, null, TipoCozinha.BRASILEIRA.toString(), null, null));
        assertNotNull(restauranteNulo);
        verify(restauranteRepository, never()).save(Objects.requireNonNull(restauranteNulo.getBody()).toModel());
    }

    @Test
    void testCriarRestauranteNulo(){
        when(restauranteRepository.save(null)).thenReturn(restaurante);
        var responseEntity = restauranteService.cadastrar(new RestauranteDto(restaurante.getNome(), restaurante.getLocalizacao(), restaurante.getTipoCozinha().toString(), restaurante.getHorarioFuncionamento(), restaurante.getCapacidade()));
        assertEquals("Teste Mockito", Objects.requireNonNull(responseEntity.getBody()).nome());
    }

    @Test
    void testGetRestaurante(){
        List<Restaurante> lista = new ArrayList<>();
        lista.add(restaurante);
        when(restauranteRepository.findAll()).thenReturn(lista);
        var todos = restauranteService.todos();
        assertEquals("Teste Mockito", todos.get(0).getNome());
    }
    @Test
    void testGetParametro(){
        List<Restaurante> lista = new ArrayList<>();
        lista.add(restaurante);
        when(restauranteRepository.pesquisaPorParametro("nome", "Teste Mockito")).thenReturn(lista);
        var restaurantes = restauranteService.pesquisaPorParametro("nome", restaurante.getNome());
        assertEquals("SP", restaurantes.get(0).getLocalizacao());
    }



}
