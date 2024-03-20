package com.demo.springboot.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.springboot.utils.GlobalConstant.BASE_URL;
import static com.demo.springboot.utils.GlobalConstant.HOME_CONTROLLER;

@RestController
@RequestMapping(BASE_URL+HOME_CONTROLLER)
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> homeMapping(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Demo Home updated");
    }
    @GetMapping("/new")
    public ResponseEntity<?> newRoute(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to new route");
    }
    @GetMapping("/simran")
    public ResponseEntity<?> simran(){
        return ResponseEntity.status(HttpStatus.OK).body("Hi! Simran");
    }

}
