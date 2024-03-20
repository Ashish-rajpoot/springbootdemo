package com.demo.springboot.CustomException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class CountryInValidException extends Exception {
public CountryInValidException (String message){
        super(message);
    }
}
