package com.folksdev.account.service;

import com.folksdev.account.dto.CustomerDto;
import com.folksdev.account.dto.CustomerDtoConverter;
import com.folksdev.account.exception.CustomerNotFoundException;
import com.folksdev.account.model.Customer;
import com.folksdev.account.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    public void setUp() { // Bu kısım testi setup etmek için yazılır
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository, converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() { //test isimlerinin açıklayıcı olması önemlidir
        Customer customer = new Customer("id", "name", "Surname", Set.of());// Önce eldeki datalar girilir
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));// customerRepositoryden findById metodunu çağırdığımda bana ilgili customer ı dönsün

        Customer result = service.findCustomerById("id");

        Assert.assertEquals(result, customer); //resultla customerı eşitlesin diye
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() { //test isimlerinin açıklayıcı olması önemlidir
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());// customerRepositoryden findById metodunu çağırdığımda bana ilgili customer ı dönsün

        Assert.assertThrows(CustomerNotFoundException.class, () -> service.findCustomerById("id"));

    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer() { //test isimlerinin açıklayıcı olması önemlidir
        Customer customer = new Customer("id", "name", "Surname", Set.of());// Önce eldeki datalar girilir
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));// customerRepositoryden findById metodunu çağırdığımda bana ilgili customer ı dönsün
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);
        CustomerDto result = service.getCustomerById("id");

        Assert.assertEquals(result, customerDto); //resultla customerı eşitlesin diye
    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException() { //test isimlerinin açıklayıcı olması önemlidir

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());// customerRepositoryden findById metodunu çağırdığımda bana ilgili customer ı dönsün
        Assert.assertThrows(CustomerNotFoundException.class, () -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter); //Intereaction converterın hiçbir metodu çağırılmasın demek
    }
}