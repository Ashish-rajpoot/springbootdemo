package com.demo.springboot.entity;

import com.demo.springboot.validators.ValidCountry;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String lastName;
    @ValidCountry
    @Column(nullable = false)
    private String country;

}
