package edu.uw.cp520.scg.util;

import java.util.Objects;

/**
 * The Address enum for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public class Address implements java.io.Serializable {

    /**
     * The state property.
     */
    private StateCode state;

    /**
     * The streetNumber property.
     */
    private String streetNumber;

    /**
     * The city property.
     */
    private String city;

    /**
     * The postalCode property.
     */
    private String postalCode;

    /**
     * The constructor for the Address enum.
     * 
     * @param streetNumber The street number passed in for the enum.
     * @param city         The city that the address contains.
     * @param state        The state that the address contains.
     * @param postalCode   The postal code that the address contains.
     */
    public Address(String streetNumber, String city, StateCode state,
        String postalCode) {
        this.state = state;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    /**
     * The getCity getter for the Address enum.
     * 
     * @return String The city property.
     */
    public String getCity() {
        return city;
    }

    /**
     * The getPostalCode getter for the Address enum.
     * 
     * @return String The postalCode property.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * The getState getter for the Address enum.
     * 
     * @return String The state property.
     */
    public StateCode getState() {
        return state;
    }

    /**
     * The getStreetNumber getter for the Address enum.
     * 
     * @return String The streetNumber property.
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * The hashCode method for generating a hashcode from the Address enum's
     * properties.
     * 
     * @return int The hashed value of the Address enum instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, postalCode, state, streetNumber);
    }

    /**
     * The equals method for the Address enum.
     * 
     * @param obj The object being passed in for comparison.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Address))
            return false;
        Address other = (Address) obj;
        return Objects.equals(city, other.city)
            && Objects.equals(postalCode, other.postalCode)
            && state == other.state
            && Objects.equals(streetNumber, other.streetNumber);
    }

    /**
     * The toString method for the Address enum.
     * 
     * @return String The human readable string for the Address enum.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getStreetNumber()).append("\n").append(getCity()).append(", ")
            .append(getState()).append(" ").append(getPostalCode());
        return sb.toString();
    }
}
