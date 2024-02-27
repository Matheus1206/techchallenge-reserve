package com.example.demo.services;

import com.example.demo.repository.RestauranteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RestauranteDto;

@Service
public class RestauranteService {

    private RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public ResponseEntity<RestauranteDto> create(RestauranteDto restaurantDto) {
        restauranteRepository.save(restaurantDto.toModel());
        return ResponseEntity.ok(restaurantDto);
    }

}
