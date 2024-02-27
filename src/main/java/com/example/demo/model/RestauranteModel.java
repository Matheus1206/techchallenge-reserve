package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class RestauranteModel {
    @Id
    private String id;

    private String nome;

    private String localizacao;

    private String tipoCozinha;

    private String horarioFuncionamento;

    private Integer capacidade;

    public RestauranteModel(){}

    public RestauranteModel(String nome, String localizacao, String tipoCozinha, String horarioFuncionamento, Integer capacidade) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.capacidade = capacidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public Integer getCapacidade() {
        return capacidade;
    }
}
