package com.folksdev.account.dto;

import com.folksdev.account.Enum.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {

    private String id;

    private TransactionType transactionType;
    private BigDecimal amount;

    private LocalDateTime transactionDate;

    public TransactionDto(String id, TransactionType transactionType, BigDecimal amount, LocalDateTime transactionDate) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }


}
