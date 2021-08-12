package com.chernoivan.booking.service;

import com.chernoivan.booking.domain.Customer;
import com.chernoivan.booking.dto.CustomerCreateDTO;
import com.chernoivan.booking.dto.CustomerPatchDTO;
import com.chernoivan.booking.dto.CustomerReadDTO;
import com.chernoivan.booking.exception.EntityNotFoundException;
import com.chernoivan.booking.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Sql(statements = "delete from customer", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Alex");
        customer.setEmail("1234qwerty@gmail.com");
        customer = customerRepository.save(customer);

        CustomerReadDTO readDTO = customerService.getCustomer(customer.getId());
        Assertions.assertThat(readDTO).isEqualToComparingFieldByField(customer);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGetCustomerWrongId() {
        customerService.getCustomer(UUID.randomUUID());
    }

    @Test
    public void testCreateCustomer() {
        CustomerCreateDTO create = new CustomerCreateDTO();
        create.setFirstName("Alex");
        create.setEmail("1234qwerty@gmail.com");
        CustomerReadDTO read = customerService.createCustomer(create);
        Assertions.assertThat(create).isEqualToComparingFieldByField(read);
        Assert.assertNotNull(read.getId());

        Customer customer = customerRepository.findById(read.getId()).get();
        Assertions.assertThat(read).isEqualToComparingFieldByField(customer);
    }

    @Test
    public void testPatchCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Alex");
        customer.setEmail("1234qwerty@gmail.com");
        customer = customerRepository.save(customer);

        CustomerPatchDTO patch = new CustomerPatchDTO();
        patch.setFirstName("Alexander");
        patch.setEmail("123");
        CustomerReadDTO read = customerService.patchCustomer(customer.getId(), patch);

        Assertions.assertThat(patch).isEqualToComparingFieldByField(read);

        customer = customerRepository.findById(read.getId()).get();
        Assertions.assertThat(customer).isEqualToComparingFieldByField(read);
    }
}