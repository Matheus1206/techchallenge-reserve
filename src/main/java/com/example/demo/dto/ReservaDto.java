package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservaDto(@NotBlank @JsonProperty("email") String emailCliente, @NotBlank String mesa, @NotNull @Min(1) @Max(4) Integer lugares, @NotBlank @JsonProperty("data") String dataReserva, @JsonIgnoreProperties String observacao) {
}
