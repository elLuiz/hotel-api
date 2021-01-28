package com.spring.springmongodb.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class ExceptionModel {
    private OffsetDateTime timeException;
    private int status;
    private String message;
    private ArrayList<Field> fields;

    public ExceptionModel(int status, String message) {
        this.timeException = OffsetDateTime.now();
        this.status = status;
        this.message = message;
    }

    public ExceptionModel(int status, String message, ArrayList<Field> fields) {
        this.timeException = OffsetDateTime.now();
        this.status = status;
        this.message = message;
        this.fields = fields;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field{
        private String field;
        private String errorDescription;
    }
}
