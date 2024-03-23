package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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

    private List<HorarioFuncionamento> horarioFuncionamento;

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
