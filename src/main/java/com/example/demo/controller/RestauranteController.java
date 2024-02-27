package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestauranteDto;
import com.example.demo.services.RestauranteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/restaurante")
public class RestauranteController {

    private final RestauranteService restaurantService;

    public RestauranteController(RestauranteService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping()
    public ResponseEntity<RestauranteDto> postMethodName(@RequestBody @Valid RestauranteDto restaurantDto) {
        return restaurantService.create(restaurantDto);
    }

}
