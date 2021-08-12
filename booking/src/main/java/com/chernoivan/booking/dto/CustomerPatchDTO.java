package com.chernoivan.booking.dto;

import lombok.Data;

@Data
public class CustomerPatchDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userType;
}
