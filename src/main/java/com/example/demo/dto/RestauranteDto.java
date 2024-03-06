package com.example.demo.dto;

import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestauranteDto(@NotBlank String nome, @NotBlank String localizacao, @NotBlank String tipoCozinha, @NotBlank String horarioFuncionamento, @NotNull Integer capacidade ) {

    public Restaurante toModel() {
        return new Restaurante(nome, localizacao, TipoCozinha.valueOf(tipoCozinha.toUpperCase()), horarioFuncionamento, capacidade);
    }
}
