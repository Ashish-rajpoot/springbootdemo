package com.demo.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.springboot.utils.GlobalConstant.*;

@RestController
@RequestMapping(BASE_URL+USER_CONTROLLER)
public class UserController {

    @PostMapping(value = ADD_USER,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > postDate(){
        return ResponseEntity.status(HttpStatus.OK).body("posted");
    }
}
