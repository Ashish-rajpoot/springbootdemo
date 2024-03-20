package com.demo.springboot.entity;

import com.demo.springboot.validators.ValidCountry;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String country;

}
