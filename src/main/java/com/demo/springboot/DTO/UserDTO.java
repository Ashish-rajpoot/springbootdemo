package com.demo.springboot.DTO;

import com.demo.springboot.validators.ValidCountry;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class UserDTO {

    private String firstName;
    private String mobileNumber;
    private String email;
    private String lastName;
    @ValidCountry
    private String country;

}
