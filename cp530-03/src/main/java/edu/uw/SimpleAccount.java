package edu.uw;

import java.io.Serializable;
import java.util.Optional;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.account.Address;
import edu.uw.ext.framework.account.CreditCard;
import edu.uw.ext.framework.order.Order;

/**
 * The SimpleAccount class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccount implements Account, Serializable {

    /**
     * The address property.
     */
    private Address address;

    /**
     * The creditCard property.
     */
    private CreditCard creditCard;

    /**
     * The balance property.
     */
    private int balance;

    /**
     * The email property.
     */
    private String email;

    /**
     * The fullName property.
     */
    private String fullName;

    /**
     * The acctName property.
     */
    private String acctName;

    /**
     * The phone property.
     */
    private String phone;

    /**
     * The pw property.
     */
    private byte[] pw;

    /**
     * The am (accountManager) property.
     */
    private transient Optional<AccountManager> am = Optional.empty();

    /**
     * The no argument constructor for the SimpleAccount class.
     */
    public SimpleAccount() {
    }

    /**
     * The 3 parameter constructor for the SimpleAccount class.
     * 
     * @param acctName The account name used for construction.
     * @param pw       The password used for construction.
     * @param balance  The balance used for construction.
     * @throws AccountException The exception thrown when a bad parameter is
     *                          passed.
     */
    public SimpleAccount(String acctName, byte[] pw, int balance)
        throws AccountException {
        this.acctName = acctName;
        this.pw = pw;
        this.balance = balance;
    }

    /**
     * The getAddress getter for the class.
     * 
     * @return Address The address returned.
     */
    @Override
    public Address getAddress() {
        return this.address;
    }

    /**
     * The getBalance getter for the balance property.
     * 
     * @return int The balane returned.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     * The getCreditCard getter for the creditCard property.
     * 
     * @return CreditCard The credit card returned.
     */
    @Override
    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    /**
     * The getEmail getter for the email property.
     * 
     * @return String The email returned.
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * The getFullName getter for the getFullName property.
     * 
     * @return String The full name returned.
     */
    @Override
    public String getFullName() {
        return this.fullName;
    }

    /**
     * The getName getter for the acctName property.
     * 
     * @return String The account name returned.
     */
    @Override
    public String getName() {
        return this.acctName;
    }

    /**
     * The getPasswordHash for the pw property.
     * 
     * @return byte[] The hashed password.
     */
    @Override
    public byte[] getPasswordHash() {
        byte[] duplicate = null;
        if (pw != null) {
            duplicate = new byte[pw.length];
            System.arraycopy(pw, 0, duplicate, 0, pw.length);
        }
        return duplicate;
    }

    /**
     * The getPhone getter for the phone property.
     * 
     * @return String The phone number returned.
     */
    @Override
    public String getPhone() {
        return this.phone;
    }

    /**
     * The reflectOrder for the class.
     * 
     * @param arg0 The order to be used.
     * @param arg1 The price of the stock.
     */
    @Override
    public void reflectOrder(Order arg0, int arg1) {
//        setBalance(balance + (arg0.getNumberOfShares() * arg1));
        setBalance(balance + arg0.valueOfOrder(arg1));
    }

    /**
     * The registerAccountManager method for the class.
     * 
     * @param m The AccountManager class to be assigned.
     */
    @Override
    public void registerAccountManager(AccountManager accountManager) {
        if (!am.isPresent()) {
            am = Optional.of(accountManager);
            am.ifPresent((m) -> persist(m));

        }
    }

    /**
     * The setAddress setter for the address property.
     * 
     * @param address The address to be set.
     */
    @Override
    public void setAddress(Address address) {
        this.address = address;
        am.ifPresent((prop) -> persist(prop));
    }

    /**
     * The setBalance setter for the balance property.
     * 
     * @param balance The balance to be set.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
        am.ifPresent((prop) -> persist(prop));
    }

    /**
     * The setCreditCard setter for the credtCard property.
     * 
     * @param card The credit card to be set.
     */
    @Override
    public void setCreditCard(CreditCard card) {
        this.creditCard = card;
        am.ifPresent((prop) -> persist(prop));

    }

    /**
     * The setEmail setter for the email property.
     * 
     * @param email The email to be set.
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
        am.ifPresent((prop) -> persist(prop));

    }

    /**
     * The setFullName setter for the fullName property.
     * 
     * @param fullName The full name to be set.
     */
    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
        am.ifPresent((prop) -> persist(prop));
    }

    /**
     * The setName setter for the acctName property.
     * 
     * @param acctName The account name to be set.
     */
    @Override
    public void setName(String acctName) throws AccountException {
        if (acctName.length() < 8) {
            throw new AccountException(
                "name needs to be eight or more characters");
        } else {
            this.acctName = acctName;
        }
        am.ifPresent((prop) -> persist(prop));

    }

    /**
     * The setPasswordHash setter for the pw property.
     * 
     * @param passwordHash The pw to be set.
     */
    @Override
    public void setPasswordHash(byte[] passwordHash) {
        this.pw = passwordHash;
        am.ifPresent((prop) -> persist(prop));

    }

    /**
     * The setPhonesetter for the phone property.
     * 
     * @param phone The phone to be set.
     */
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
        am.ifPresent((prop) -> persist(prop));

    }

    /**
     * The persist method. This is a custom method to ease persisting an
     * account.
     * 
     * @param accMan The accountmanager to use for persistence.
     */
    public void persist(AccountManager accMan) {
        try {
            accMan.persist(this);
        } catch (AccountException e) {
            e.printStackTrace();
        }
    }

}
