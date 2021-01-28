package com.spring.springmongodb.api.controller;

import com.spring.springmongodb.api.dto.ExceptionModel;
import com.spring.springmongodb.api.exception.client.ClientException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<Object> handleClientException(ClientException clientException, WebRequest webRequest){
        HttpStatus httpStatus = getHttpStatus(clientException.getStatusCode());
        ExceptionModel exception = new ExceptionModel(httpStatus.value(), clientException.getMessage());

        return handleExceptionInternal(clientException, exception, new HttpHeaders(), httpStatus, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel(status.value(), "Request error.",
                getFieldErrorDescription(ex));
        return super.handleExceptionInternal(ex, exceptionModel, headers, status, request);
    }

    private ArrayList<ExceptionModel.Field> getFieldErrorDescription(MethodArgumentNotValidException methodArgumentNotValidException){
        ArrayList<ExceptionModel.Field> fields = new ArrayList<>();
        methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .forEach(error -> fields.add(new ExceptionModel.Field(((FieldError) error).getField(), error.getDefaultMessage())));

        return fields;
    }

    private HttpStatus getHttpStatus(int code){
        return HttpStatus.resolve(code);
    }
}
