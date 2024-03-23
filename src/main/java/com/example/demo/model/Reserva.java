package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document
@ToString
@Getter
public class Reserva {
    @Id
    private String id;
    @NotBlank
    @JsonProperty("email")
    private String emailCliente;
    @NotNull
    @Min(1) @Max(4)
    private Integer lugares;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime dataReserva;

    private Boolean statusReserva;

    private String observacao;

    private Restaurante restaurante;

    public Reserva(){}

    public Reserva(String cliente, Integer lugares, LocalDateTime dataReserva, String observacao, Restaurante restaurante) {
        this.emailCliente = cliente;
        this.lugares = lugares;
        this.dataReserva = dataReserva;
        this.observacao = observacao;
        this.statusReserva = true;
        this.restaurante = restaurante;
    }

    public void setStatusReserva() {
        this.statusReserva = !statusReserva;
    }
}
