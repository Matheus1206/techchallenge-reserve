package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@NoArgsConstructor
@Document
public class Cliente {

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;

    private String nome;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
