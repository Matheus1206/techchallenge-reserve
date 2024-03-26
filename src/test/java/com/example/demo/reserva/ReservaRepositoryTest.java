package com.example.demo.reserva;

import com.example.demo.repository.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class ReservaRepositoryTest {
    @Autowired
    private ReservaRepository reservaRepository;

    @Test
    void devePermitirCriarTabela(){
        var totalDeRegistros = reservaRepository.count();
        assertThat(totalDeRegistros).isNotNegative();
    }
}
