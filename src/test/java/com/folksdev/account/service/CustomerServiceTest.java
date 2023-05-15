package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDtoConverter;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private CustomerService service;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerDtoConverter converter;

    @BeforeEach //Her bir Test methodu çalışmadan önce belirli bir işlemi gerçekleştirmek için kullanılır
     void setUp(){ // Bu kısım testi setup etmek için yazılır

        service = new CustomerService(customerRepository, converter);
    }

    @Test
     void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){ //test isimlerinin açıklayıcı olması önemlidir
        Customer customer = new Customer("id", "name", "Surname", Set.of() );// Önce eldeki datalar girilir
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));// customerRepositoryden findById metodunu çağırdığımda bana ilgili customer ı dönsün

        Customer result = service.findCustomerById("id");

        Assert.assertEquals(result, customer); //resultla customerı eşitlesin diye
    }

}