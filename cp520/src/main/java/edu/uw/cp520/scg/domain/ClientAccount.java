package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;

/**
 * The ClientAccount class for the invoice project. It encapsulates the details
 * of a client account.
 * 
 * @author Toby Peterson.
 *
 */
public final class ClientAccount implements Account {

    /**
     * The contact property.
     */
    private PersonalName contact;

    /**
     * The name property.
     */
    private String name;

    /**
     * The two-parameter constructor for the ClientAccount class.
     * 
     * @param name    The name of the account.
     * @param contact The contact for the account.
     */
    public ClientAccount(String name, PersonalName contact) {
        this.name = name;
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
}
