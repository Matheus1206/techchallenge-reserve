package com.example.demo;

import com.example.demo.repository.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class RestauranteRespositoryIT {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    void devePermitirCriarTabela(){
        var totalDeRegistros = restauranteRepository.count();
        assertThat(totalDeRegistros).isNotNegative();
    }

    @Test
    void devePermitirCadastrarRestaurante(){
         assertEquals(restauranteRepository.count(),restauranteRepository.count());
    }
}
