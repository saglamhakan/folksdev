package com.folksdev.account.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "UUID") //Benzersiz ve rastgele ıd oluşturması için kullanılır
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Account> accounts;

    public Customer() {}

    public Customer(String customerId, String name, String surname, Set<Account> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.accounts=accounts;
    }

    public Customer(String name, String surname) {
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + "{"
                +"id = " + customerId
                +", name = " + name
                +", surname = " + surname
                +", accounts =" + new HashSet<>()
                + "}";
    }
}
