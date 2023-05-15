package com.folksdev.account.dto;

public class CreateCustomerRequest {

    private String name;
    private String surname;

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



    public CreateCustomerRequest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


}
