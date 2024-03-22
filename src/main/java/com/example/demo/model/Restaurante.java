package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

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

    private List<HorarioFuncionamento> horarioFuncionamento = new ArrayList<>();

    private Integer capacidade;

    public Restaurante(){}

    public Restaurante(String nome, String localizacao, List<HorarioFuncionamento> horarioFuncionamento, TipoCozinha tipoCozinha,Integer capacidade) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.capacidade = capacidade;
    }
}
