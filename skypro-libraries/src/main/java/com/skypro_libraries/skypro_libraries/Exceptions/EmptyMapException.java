package com.skypro_libraries.skypro_libraries.Exceptions;

public class EmptyMapException extends RuntimeException {
    public EmptyMapException(Exception e) {
        super(e);
    }

    public EmptyMapException(String e) {
        System.out.println(e);
    }
}
