package com.demo.springboot.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

    @InjectMocks
    HomeController homeController;

    @Test
    void testHomeMapping() {
        ResponseEntity<?> responseEntity = homeController.homeMapping();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Welcome to Demo Home updated", responseEntity.getBody());

    }

    @Test
    void testNewMapping(){
        ResponseEntity<?> responseEntity = homeController.newRoute();
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Welcome to new route",responseEntity.getBody());

    }

    @Test
    void testSimran(){
        ResponseEntity<?> responseEntity = homeController.simran();
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Hi! Simran",responseEntity.getBody());
    }

}
