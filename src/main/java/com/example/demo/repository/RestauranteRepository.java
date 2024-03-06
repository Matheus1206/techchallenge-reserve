package com.example.demo.repository;

import com.example.demo.model.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface RestauranteRepository extends MongoRepository<Restaurante, Long> {
    @Query("{?0:?1}")
    List<Restaurante> pesquisaPorParametro(String parametro, String valor);
}
