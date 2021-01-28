package com.spring.springmongodb.api.exception.client;


import lombok.Getter;

@Getter
public class ClientException extends RuntimeException{
    protected int statusCode;

    public ClientException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public ClientException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
