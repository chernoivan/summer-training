package com.chernoivan.booking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.chernoivan.booking.domain.Customer;
import com.chernoivan.booking.dto.CustomerCreateDTO;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.exception.EntityNotFoundException;
import com.chernoivan.booking.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetUser() throws Exception {
        CustomerReadDTO customer = new CustomerReadDTO();
        customer.setId(UUID.randomUUID());
        customer.setFirstName("Alex");
        customer.setEmail("qwerty1234@gmail.com");

        Mockito.when(customerService.getCustomer(customer.getId())).thenReturn(customer);

        String resultJson = mvc.perform(get("/api/v1/users/{id}", customer.getId()))
                .andExpect(status().isOk()).andReturn()
                .getResponse().getContentAsString();

        System.out.println(resultJson);
        CustomerReadDTO actualCustomer = objectMapper.readValue(resultJson, CustomerReadDTO.class);
        Assertions.assertThat(actualCustomer).isEqualToComparingFieldByField(customer);

        Mockito.verify(customerService).getCustomer(customer.getId());
    }

    @Test
    public void testGetCustomerWrongId() throws Exception {
        UUID wrongId = UUID.randomUUID();

        EntityNotFoundException exception = new EntityNotFoundException(Customer.class, wrongId);
        Mockito.when(customerService.getCustomer(wrongId)).thenThrow(exception);

        String resultJson = mvc.perform(get("/api/v1/users/{id}", wrongId))
                .andExpect(status().isNotFound()).andReturn()
                .getResponse().getContentAsString();

        Assert.assertTrue(resultJson.contains(exception.getMessage()));
        ;
    }

    @Test
    public void testCreateCustomer() throws Exception {

        CustomerCreateDTO create = new CustomerCreateDTO();
        create.setFirstName("Alex");
        create.setEmail("123");

        CustomerReadDTO read = new CustomerReadDTO();
        read.setId(UUID.randomUUID());
        read.setFirstName("Alex");
        read.setEmail("123");

        Mockito.when(customerService.createCustomer(create)).thenReturn(read);

        String resultJson = mvc.perform(post("/api/v1/users/")
                .content(objectMapper.writeValueAsString(create))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        CustomerReadDTO actualCustomer = objectMapper.readValue(resultJson, CustomerReadDTO.class);
        Assertions.assertThat(actualCustomer).isEqualToComparingFieldByField(read);
    }
}