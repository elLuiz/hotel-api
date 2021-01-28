package com.spring.springmongodb.api.exception.client;

public class EntityNotFound extends ClientException{
    public EntityNotFound(String message) {
        super(message, 404);
    }
}
