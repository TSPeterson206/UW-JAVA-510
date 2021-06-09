package edu.uw;

import edu.uw.ext.framework.account.CreditCard;

/**
 * The SimpleCreditCard class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleCreditCard implements CreditCard {

    /**
     * The accountNumber property.
     */
    private String accountNumber;

    /**
     * The expDate property.
     */
    private String expDate;

    /**
     * The holder property.
     */
    private String holder;

    /**
     * The issuer property.
     */
    private String issuer;

    /**
     * The type property.
     */
    private String type;

    /**
     * The no argument constructor for the class.
     */
    public SimpleCreditCard() {
    }

    /**
     * The getAccountNumber getter for the class.
     * 
     * @return String The account number property.
     */
    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * The getExpirationDate getter for the class.
     * 
     * @return String The expiration property.
     */
    @Override
    public String getExpirationDate() {
        return this.expDate;
    }

    /**
     * The getHolder getter for the class.
     * 
     * @return String The card holder property.
     */
    @Override
    public String getHolder() {
        return this.holder;
    }

    /**
     * The getIssuer getter for the class.
     * 
     * @return String The issuer property.
     */
    @Override
    public String getIssuer() {
        return this.issuer;
    }

    /**
     * The getType getter for the class.
     * 
     * @return String The type property.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * The setAccountNumber setter for the class.
     * 
     * @param accountNumber The account number to be set.
     */
    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * The setExpirationDate setter for the class.
     * 
     * @param expDate The expiration date to be set.
     */
    @Override
    public void setExpirationDate(String expDate) {
        this.expDate = expDate;
    }

    /**
     * The setHolder setter for the class.
     * 
     * @param name The holder to be set.
     */
    @Override
    public void setHolder(String name) {
        this.holder = name;
    }

    /**
     * The setIssuer setter for the class.
     * 
     * @param issuer The issuer to be set.
     */
    @Override
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * The setType setter for the class.
     * 
     * @param type The card type to be set.
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

}
