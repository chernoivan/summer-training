package com.chernoivan.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class CustomerReadDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userType;

}
