package com.folksdev.account.service;

import com.folksdev.account.dto.AccountDto;
import com.folksdev.account.dto.AccountDtoConverter;
import com.folksdev.account.dto.CreateAccountRequest;
import com.folksdev.account.model.Account;
import com.folksdev.account.model.Customer;
import com.folksdev.account.model.Transaction;
import com.folksdev.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    private final AccountDtoConverter converter;// @Component olduğu için injection yapabildik ve unit test yazabileceğiz.

    public AccountService(AccountRepository accountRepository, CustomerService customerService,  AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService=customerService;
        this.converter=converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getId());

        Account account = new Account(createAccountRequest.getInitialCredit(), LocalDateTime.now(), customer);

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)> 0) {   //compareTo Bigdecimal 0 dan büyükse 1 0 a eşitse 0 1den küçükse -1 dönüyor
          //  Transaction transaction = transactionService.initiateMoney(account,createAccountRequest.getInitialCredit());
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            transaction.setTransactionDate(LocalDateTime.now());
            account.getTransaction().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }

}
