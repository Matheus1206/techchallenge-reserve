package com.example.demo.services;

import com.example.demo.model.Restaurante;
import com.example.demo.repository.RestauranteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RestauranteDto;

import java.util.List;

@Service
public class RestauranteService {

    private RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public ResponseEntity<RestauranteDto> cadastrar(RestauranteDto restaurantDto) {
        restauranteRepository.save(restaurantDto.toModel());
        return ResponseEntity.ok(restaurantDto);
    }

    public List<Restaurante> todos() {
        return restauranteRepository
                .findAll();
    }

    public List<Restaurante> pesquisaPorParametro(String parametro, String valor) {
        return restauranteRepository.pesquisaPorParametro(parametro, valor);
    }
}
