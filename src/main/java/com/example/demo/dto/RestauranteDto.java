package com.example.demo.dto;

import com.example.demo.model.HorarioFuncionamento;
import com.example.demo.model.Restaurante;
import com.example.demo.model.TipoCozinha;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RestauranteDto(@NotBlank String nome, @NotBlank String localizacao, @NotBlank String tipoCozinha, @NotNull @NotEmpty List<HorarioFuncionamento> horarioFuncionamentos, @NotNull Integer capacidade ) {

    public Restaurante toModel() {
        return new Restaurante(nome, localizacao ,horarioFuncionamentos, TipoCozinha.valueOf(tipoCozinha.toUpperCase()), capacidade);
    }
}
