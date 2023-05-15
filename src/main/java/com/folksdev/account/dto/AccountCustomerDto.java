package com.folksdev.account.dto;

public class AccountCustomerDto {

    private String id;
    private String surname;
    private String name;


    public AccountCustomerDto(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
