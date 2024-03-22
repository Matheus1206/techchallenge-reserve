package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Restaurante {
    @Id
    private String id;

    private String nome;

    private String localizacao;

    private TipoCozinha tipoCozinha;

    private String horarioInicial;

    private String horarioFinal;

    private Integer capacidade;

    public Restaurante(){}

    public Restaurante(String nome, String localizacao, TipoCozinha tipoCozinha, String horarioInicial, String horaFinal,Integer capacidade) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.horarioFinal = horaFinal;
        this.horarioInicial = horarioInicial;
        this.capacidade = capacidade;
    }
}
