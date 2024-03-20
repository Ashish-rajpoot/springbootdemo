package com.demo.springboot.CustomException;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
