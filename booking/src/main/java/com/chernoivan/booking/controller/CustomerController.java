package com.chernoivan.booking.controller;

import com.chernoivan.booking.domain.Customer;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerReadDTO getApplicationUser(@PathVariable UUID id) {
        return customerService.getCustomer(id);
    }
}
