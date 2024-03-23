package com.example.demo.repository;

import com.example.demo.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
    @Query("{'restaurante.nome': '?0'}")
    List<Reserva> findReservaRestauranteNome(String nome);
}
