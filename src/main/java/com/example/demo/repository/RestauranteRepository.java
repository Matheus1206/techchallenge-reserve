package com.example.demo.repository;

import com.example.demo.model.RestauranteModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RestauranteRepository extends MongoRepository<RestauranteModel, Long> {
}
