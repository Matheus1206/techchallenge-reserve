package com.example.demo.controller;

import com.example.demo.model.Restaurante;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RestauranteDto;
import com.example.demo.services.RestauranteService;

import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/restaurante")
public class RestauranteController {

    private final RestauranteService restaurantService;

    public RestauranteController(RestauranteService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping()
    public ResponseEntity<RestauranteDto> cadastrar(@RequestBody @Valid RestauranteDto restaurantDto) {
        return restaurantService.cadastrar(restaurantDto);
    }

    @GetMapping("/todos")
    public List<Restaurante> todos() {
        return restaurantService.todos();
    }

    @GetMapping("/pesquisa")
    public List<Restaurante> pesquisaParametro(@RequestParam String parametro, @RequestParam String valor){
        return restaurantService.pesquisaPorParametro(parametro , valor);
    }
}
