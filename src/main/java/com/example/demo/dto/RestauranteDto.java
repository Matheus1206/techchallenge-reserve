package com.example.demo.dto;

import com.example.demo.model.RestauranteModel;
import jakarta.validation.constraints.NotBlank;

public record RestauranteDto(@NotBlank String nome, @NotBlank String localizacao, @NotBlank String tipoCozinha, @NotBlank String horarioFuncionamento, @NotBlank Integer capacidade ) {

    public RestauranteModel toModel() {
        return new RestauranteModel(nome, localizacao, tipoCozinha, horarioFuncionamento, capacidade);
    }
}
