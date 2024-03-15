package com.demo.springboot.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> homeMapping(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Demo Home updated");
    }
    @GetMapping("/new")
    public ResponseEntity<?> newRoute(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to new route ");
    }
    @GetMapping("/simran")
    public ResponseEntity<?> gav(){
        return ResponseEntity.status(HttpStatus.OK).body("Gaurav");
    }
}
