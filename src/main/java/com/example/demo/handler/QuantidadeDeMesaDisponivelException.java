package com.example.demo.handler;

public class QuantidadeDeMesaDisponivelException extends Exception {

    public QuantidadeDeMesaDisponivelException(){
        super("Quantidade de lugares indisponível, tente outro restaurante");
    }
}
