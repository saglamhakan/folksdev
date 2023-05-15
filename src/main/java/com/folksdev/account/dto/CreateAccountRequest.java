package com.folksdev.account.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {

    private String id;

    private BigDecimal initialCredit;


    public CreateAccountRequest(String id, BigDecimal initialCredit) {
        this.id = id;
        this.initialCredit = initialCredit;


    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }


}
