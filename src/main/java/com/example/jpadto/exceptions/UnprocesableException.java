package com.example.jpadto.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnprocesableException  extends RuntimeException{
    public UnprocesableException(String message) {
        super(message);
    }
}
