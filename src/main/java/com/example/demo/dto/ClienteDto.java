package com.example.demo.dto;

import com.example.demo.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDto(@NotBlank String nome, @NotBlank @Email String email) {
    public Cliente toModel() {
        return Cliente.builder()
                .email(email)
                .nome(nome)
                .build();
    }
}
