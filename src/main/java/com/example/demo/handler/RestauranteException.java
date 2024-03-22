package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestauranteException extends Exception{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methodArgumentNotValidException(MethodArgumentNotValidException validException){
        return validException.getMessage();
    }

    @ExceptionHandler(QuantidadeDeMesaDisponivelException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String quantidadeDeMesaDisponnivelException(QuantidadeDeMesaDisponivelException validException){
        return validException.getMessage();
    }

}
