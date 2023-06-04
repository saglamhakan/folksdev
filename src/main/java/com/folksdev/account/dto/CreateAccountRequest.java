package com.folksdev.account.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class CreateAccountRequest {

    @NotBlank(message = "Customer id could not empty") //buraya mesaj yazmasakta default mesaj döner
    private String id;
    @Min(0)
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
