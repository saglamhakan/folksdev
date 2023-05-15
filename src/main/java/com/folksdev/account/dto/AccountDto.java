package com.folksdev.account.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class AccountDto {

    private String id;

    private BigDecimal balance;

    private LocalDateTime creationDate;

    private AccountCustomerDto customer;

    private Set<TransactionDto> transactions;

    public AccountDto(String id, BigDecimal balance, LocalDateTime creationDate, AccountCustomerDto customer, Set<TransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transactions = transactions;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public AccountCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(AccountCustomerDto customer) {
        this.customer = customer;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }


}
