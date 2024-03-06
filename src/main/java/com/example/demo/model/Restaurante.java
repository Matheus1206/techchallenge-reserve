package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Getter
@Builder
@AllArgsConstructor
public class Restaurante {
    @Id
    private String id;

    private String nome;

    private String localizacao;

    private TipoCozinha tipoCozinha;

    private String horarioFuncionamento;

    private Integer capacidade;

    public Restaurante(){}

    public Restaurante(String nome, String localizacao, TipoCozinha tipoCozinha, String horarioFuncionamento, Integer capacidade) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.capacidade = capacidade;
    }

}
