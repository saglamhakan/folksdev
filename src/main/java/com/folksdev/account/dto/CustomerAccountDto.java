package com.folksdev.account.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class CustomerAccountDto {

    private String id;
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<TransactionDto> transactions;

    private LocalDateTime creationDate;

    public CustomerAccountDto(String id, BigDecimal balance, Set<TransactionDto> transactions, LocalDateTime creationDate) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.creationDate = creationDate;
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

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }




}
