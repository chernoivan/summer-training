package com.chernoivan.booking.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userType;

}
