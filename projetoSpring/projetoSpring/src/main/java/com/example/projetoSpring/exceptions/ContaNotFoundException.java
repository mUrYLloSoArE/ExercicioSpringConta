package com.example.projetoSpring.exceptions;

public class ContaNotFoundException extends RuntimeException{
    public ContaNotFoundException(String msg){
        super(msg);
    }
}
