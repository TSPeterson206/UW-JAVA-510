//package edu.uw.cp520.example;

package edu.uw.cp520.example;

/**
 * The Account interface for the invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public interface Account {

    /**
     * The getName method to be implemented by two other classes within this
     * project.
     * 
     * @return String The name of this account.
     */
    String getName();

    /**
     * The isBillable method for the interface.
     * 
     * @return boolean A boolean value determining whether the account is
     *         billable or not.
     */
    boolean isBillable();

}
