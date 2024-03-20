package com.demo.springboot.controllers;

import com.demo.springboot.CustomException.CountryInValidException;
import com.demo.springboot.DTO.UserDTO;
import com.demo.springboot.servicesImpls.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.springboot.utils.GlobalConstant.*;

@RestController
@RequestMapping(BASE_URL+USER_CONTROLLER)
@Validated
public class UserControllerTest {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = ADD_USER,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String > postDate(@Valid @RequestBody UserDTO userDTO) throws CountryInValidException {
        try{
        System.out.println(userDTO);
        userService.addUsers(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body("posted");
        }catch (CountryInValidException e){
            throw new CountryInValidException("County is Invalid");
        }
    }
}
