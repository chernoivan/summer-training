package com.chernoivan.booking.service;

import com.chernoivan.booking.domain.Customer;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerReadDTO getCustomer(UUID id) {
        Customer customer =  customerRepository.findById(id).get();
        return toRead(customer);
    }

    private CustomerReadDTO toRead(Customer customer) {
        CustomerReadDTO dto = new CustomerReadDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        dto.setUserType(customer.getUserType());
        return dto;
    }
}
