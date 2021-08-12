package com.chernoivan.booking.service;

import com.chernoivan.booking.domain.Customer;
import com.chernoivan.booking.dto.CustomerCreateDTO;
import com.chernoivan.booking.dto.CustomerPatchDTO;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.exception.EntityNotFoundException;
import com.chernoivan.booking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerReadDTO getCustomer(UUID id) {
        Customer customer = getCustomerRequired(id);
        return toRead(customer);
    }

    public CustomerReadDTO createCustomer(CustomerCreateDTO create) {
        Customer customer = new Customer();
        customer.setFirstName(create.getFirstName());
        customer.setLastName(create.getLastName());
        customer.setPhone(create.getPhone());
        customer.setEmail(create.getEmail());
        customer.setUserType(create.getUserType());

        customer = customerRepository.save(customer);
        return toRead(customer);
    }

    public CustomerReadDTO patchCustomer(UUID id, CustomerPatchDTO patch) {
        Customer customer = getCustomerRequired(id);

        if (patch.getFirstName() != null) {
            customer.setFirstName(patch.getFirstName());
        }
        if (patch.getLastName() != null) {
            customer.setLastName(patch.getLastName());
        }
        if (patch.getPhone() != null) {
            customer.setPhone(patch.getPhone());
        }
        if (patch.getEmail() != null) {
            customer.setEmail(patch.getEmail());
        }
        if (patch.getUserType() != null) {
            customer.setUserType(patch.getUserType());
        }
        customer = customerRepository.save(customer);
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

    private Customer getCustomerRequired(UUID id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Customer.class, id));
    }
}
