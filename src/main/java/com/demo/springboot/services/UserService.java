package com.demo.springboot.services;

import com.demo.springboot.CustomException.CountryInValidException;
import com.demo.springboot.DTO.UserDTO;

public interface UserService {

    void addUsers(UserDTO userDTO) throws CountryInValidException;
}
