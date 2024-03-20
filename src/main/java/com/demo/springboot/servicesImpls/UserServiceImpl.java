package com.demo.springboot.servicesImpls;

import com.demo.springboot.CustomException.CountryInValidException;
import com.demo.springboot.CustomException.EmailAlreadyExistsException;
import com.demo.springboot.DTO.UserDTO;
import com.demo.springboot.entity.Users;
import com.demo.springboot.repos.UserRepo;
import com.demo.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void addUsers(UserDTO userDTO) throws CountryInValidException {

        Users fetchUser = userRepo.findByEmail(userDTO.getEmail());
        if (fetchUser != null) {
            throw new EmailAlreadyExistsException("\""+fetchUser.getEmail()+"\""+ " User Already Exists");
        } else {
            Users user = new Users();
            user.setCountry(userDTO.getCountry());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setMobileNumber(userDTO.getMobileNumber());
            userRepo.save(user);
        }
    }
}
