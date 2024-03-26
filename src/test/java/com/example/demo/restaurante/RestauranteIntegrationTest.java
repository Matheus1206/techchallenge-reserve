package com.example.demo.restaurante;

import com.example.demo.dto.RestauranteDto;
import com.example.demo.model.HorarioFuncionamento;
import com.example.demo.model.TipoCozinha;
import com.example.demo.services.RestauranteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestauranteIntegrationTest {
    @Autowired
    private RestauranteService restauranteService;

    @Test
    void cadastrarRestauranteTest(){
        var dtoResponseEntity = restauranteService.cadastrar(new RestauranteDto("Teste", "SP", TipoCozinha.BRASILEIRA.toString(), Arrays.asList(HorarioFuncionamento.ALMOCO), 10));
        assertNotNull(dtoResponseEntity);
        assertEquals("SP", Objects.requireNonNull(dtoResponseEntity.getBody()).localizacao());
    }

}
