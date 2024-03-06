package com.example.demo;

import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import com.example.demo.repository.RestauranteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RestauranteTest {
    @Mock
    private RestauranteRepository restauranteRepository;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setup(){
         autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void deveCadastrarUmRestaurante(){
        //Arrange
        var restaurante = Restaurante.builder()
                .id("1")
                .nome("Spolleto")
                .localizacao("SP")
                .capacidade(23)
                .horarioFuncionamento("Noite")
                .tipoCozinha(TipoCozinha.ITALIANA)
                .build();

        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(restaurante);

        //Arrange
        var restauranteArmazenado = restauranteRepository.save(restaurante);

        //Assert
        assertThat(restauranteArmazenado)
                .isNotNull()
                .isEqualTo(restaurante);
        verify(restauranteRepository, times(1)).save(any(Restaurante.class));
    }
    @Test
    void devePesquisarRestaurantePorParametro(){
        var restaurante = Restaurante.builder()
                .id("1")
                .nome("Spolletos")
                .localizacao("SP")
                .capacidade(23)
                .horarioFuncionamento("Noite")
                .tipoCozinha(TipoCozinha.ITALIANA)
                .build();
        var listaRestaurante = Arrays.asList(restaurante);
        when(restauranteRepository.pesquisaPorParametro("nome", "Spolletos")).thenReturn(listaRestaurante);

        List<Restaurante> restaurantes = restauranteRepository.pesquisaPorParametro("nome", "Spolletos");

        assertThat(restaurantes)
                .isNotNull()
                .isEqualTo(listaRestaurante);
        assertEquals(restaurantes.get(0).getNome(), restaurante.getNome());
        verify(restauranteRepository, times(1)).pesquisaPorParametro("nome", "Spolletos");
    }
}
