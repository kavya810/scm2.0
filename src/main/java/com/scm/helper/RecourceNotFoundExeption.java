package com.scm.helper;

public class RecourceNotFoundExeption extends RuntimeException{

    public RecourceNotFoundExeption(String message){
        super(message);
    }
    public RecourceNotFoundExeption(){
        super("resource not found");        
    }
}
