package edu.uw;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.account.Address;
import edu.uw.ext.framework.account.CreditCard;
import edu.uw.ext.framework.order.Order;

public class SimpleAccount implements Account {

    private Address address;
    private CreditCard creditCard;
    private int balance;
    private String email;
    private String fullName;
    private String acctName;
    private String phone;
    private byte[] pw;
    private AccountManager am = null;

    public SimpleAccount() {
    }

    public SimpleAccount(String acctName, byte[] pw, int balance)
        throws AccountException {
//        if (acctName.length() < 8) {
//            throw new AccountException(
//                "Hey dude, name needs to be at least 8 characters!");
//        } else {
        this.acctName = acctName;
//        }
        this.pw = pw;
//        if (balance < 1000) {
//            throw new AccountException("Need to have at least a grand bro.");
//        } else {
        this.balance = balance;
//        }
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String getName() {
        return this.acctName;
    }

    @Override
    public byte[] getPasswordHash() {
        return this.pw;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public void reflectOrder(Order arg0, int arg1) {
        System.out.println(
            "$$$$$$$$$ current balance $$$$$$$$$$: " + this.getBalance());
        setBalance(balance + (arg0.getNumberOfShares() * arg1));
        System.out.println("order: " + arg0.toString() + " " + arg1);
        System.out
            .println("$$$$$$$$$ new balance $$$$$$$$$$: " + this.getBalance());

    }

//    public void reflectOrder​(edu.uw.ext.framework.order.Order order,
//        int executionPrice)
//Incorporates the effect of an order in the balance. Increments or decrements the account 
//    balance by the execution price * number of shares in the order and then persists the account, using the account manager.
//Specified by:
//reflectOrder in interface edu.uw.ext.framework.account.Account
//Parameters:
//order - the order to be reflected in the account
//executionPrice - the price the order was executed at

    @Override
    public void registerAccountManager(AccountManager m) {
        if (this.am == null) {
            this.am = m;
        }
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void setCreditCard(CreditCard card) {
        this.creditCard = card;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void setName(String acctName) throws AccountException {
        if (acctName.length() < 8) {
            throw new AccountException(
                "name needs to be eight or more characters");
        } else {
            this.acctName = acctName;
        }
    }

    @Override
    public void setPasswordHash(byte[] passwordHash) {
        this.pw = passwordHash;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
