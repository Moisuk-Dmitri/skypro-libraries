package com.skypro_libraries.skypro_libraries.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddingEmployeeException extends RuntimeException {
    public AddingEmployeeException(Exception e) {
        super(e.getMessage());
    }

    public AddingEmployeeException(String message) {
        System.out.println(message);
    }
}
