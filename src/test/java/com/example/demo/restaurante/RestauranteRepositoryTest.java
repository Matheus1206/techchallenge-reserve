package com.example.demo.restaurante;

import com.example.demo.repository.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class RestauranteRepositoryTest {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void devePermitirCriarTabela(){
        var totalDeRegistros = restauranteRepository.count();
        assertThat(totalDeRegistros).isNotNegative();
    }

}
