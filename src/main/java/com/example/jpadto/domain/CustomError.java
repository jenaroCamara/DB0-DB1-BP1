package com.example.jpadto.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje; // Devolverá el mensaje de error.
}
