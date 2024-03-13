package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@ToString
public class Reserva {
    @Id
    private String id;
    @NotBlank
    @JsonProperty("email")
    private String emailCliente;
    @NotBlank
    private String mesa;
    @NotNull
    @Min(1) @Max(4)
    private Integer lugares;
    @NotBlank
    private String dataReserva;

    private String observacao;


    public Reserva(){}

    public Reserva(String cliente, String mesa, Integer lugares, String dataReserva, String observacao) {
        this.emailCliente = cliente;
        this.mesa = mesa;
        this.lugares = lugares;
        this.dataReserva = dataReserva;
        this.observacao = observacao;
    }
}
