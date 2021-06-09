package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * The ClientAccount class for the invoice project. It encapsulates the details
 * of a client account.
 * 
 * @author Toby Peterson.
 *
 */
public final class ClientAccount
    implements Account, Comparable<ClientAccount>, java.io.Serializable {

    /**
     * The contact property.
     */
    private PersonalName contact;

    /**
     * The name property.
     */
    private String name;

    /**
     * The address property.
     */
    private Address address;

    /**
     * The two-parameter constructor for the ClientAccount class.
     * 
     * @param name    The name of the account.
     * @param contact The contact for the account.
     * @param address The address for the account.
     */
    public ClientAccount(String name, PersonalName contact, Address address) {
        this.name = name;
        setAddress(address);
        setContact(contact);
    };

    /**
     * The getter for the account contact property.
     * 
     * @return PersonalName The contact for the account.
     */
    public PersonalName getContact() {
        return this.contact;
    };

    /**
     * The setter for the account contact property.
     * 
     * @param contact The contact to be assigned.
     */
    public void setContact(PersonalName contact) {
        this.contact = contact;
    };

    /**
     * The getter for the account name.
     * 
     * @return String The human-readable account name.
     */
    @Override
    public String getName() {
        return this.name;
    };

    /**
     * The isBillable method for the ClientAccount class.
     * 
     * @return boolean A boolean value indicating whether or not the account is
     *         billable.
     */
    public boolean isBillable() {
        return true;
    };

    /**
     * The getAddress method for ClientAccount.
     * 
     * @return Address The address of the ClientAccount object.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * The setAddress setter for ClientAccount.
     * 
     * @param address The address to be listed for the ClientAccount object.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * The compareTo method for ClientAccount.
     * 
     * @param arg0 The argument object passed in for comparison.
     * @return int The integer indicating the comparison status between two
     *         objects.
     */
    @Override
    public int compareTo(ClientAccount arg0) {
        int cmp = this.getName().compareTo(arg0.getName());

        if (cmp == 0) {
            cmp = this.getContact().toString()
                .compareTo(arg0.getContact().toString());
        }
        if (cmp == 0) {
            cmp = this.getAddress().toString()
                .compareTo(arg0.getAddress().toString());
        }
        return cmp;
//        The natural ordering of ClientAccount is ascending order by name, contact and finally address.
    }

    /**
     * The toString method.
     * 
     * @return String The human readable string.
     */
    @Override
    public String toString() {
        return "ClientAccount Info: Name - " + getName().toString()
            + ", Contact - " + getContact() + ", Address - "
            + getAddress().toString();
    }
}
