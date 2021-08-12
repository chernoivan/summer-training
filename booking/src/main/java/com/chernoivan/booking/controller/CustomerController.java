package com.chernoivan.booking.controller;

import com.chernoivan.booking.dto.CustomerCreateDTO;
import com.chernoivan.booking.dto.CustomerPatchDTO;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public CustomerReadDTO createCustomer(@RequestBody CustomerCreateDTO createDTO) {
        return customerService.createCustomer(createDTO);
    }

    @PatchMapping("/{id}")
    public CustomerReadDTO patchCustomer(@PathVariable UUID id, @RequestBody CustomerPatchDTO patch) {
        return customerService.patchCustomer(id, patch);
    }
}
