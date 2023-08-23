package com.folksdev.account.dto;

import com.folksdev.account.model.Customer;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getCustomerId(), f.getName(), f.getSurname())).orElse(null);
    }


    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getCustomerId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet()));

    }

}
