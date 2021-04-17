package edu.uw;

import edu.uw.ext.framework.account.CreditCard;

public class SimpleCreditCard implements CreditCard {

    private String accountNumber;
    private String expDate;
    private String holder;
    private String issuer;
    private String type;

    public SimpleCreditCard() {
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getExpirationDate() {
        return this.expDate;
    }

    @Override
    public String getHolder() {
        return this.holder;
    }

    @Override
    public String getIssuer() {
        return this.issuer;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void setExpirationDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public void setHolder(String name) {
        this.holder = name;
    }

    @Override
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

}
