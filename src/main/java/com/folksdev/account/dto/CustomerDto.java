package com.folksdev.account.dto;

import java.util.Set;

public class CustomerDto {

    private final Set<CustomerAccountDto> accounts;
    private String customerId;
    private String name;
    private String surname;


    public CustomerDto(String customerId, String name, String surname, Set<CustomerAccountDto> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.accounts=accounts;

    }



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }




}
