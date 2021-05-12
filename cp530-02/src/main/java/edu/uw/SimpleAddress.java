package edu.uw;

import edu.uw.ext.framework.account.Address;

/**
 * The SimpleAddress class for the stock trader project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAddress implements Address {

    /**
     * The city property.
     */
    private String city;

    /**
     * The state property.
     */
    private String state;

    /**
     * The address property.
     */
    private String address;

    /**
     * The zip property.
     */
    private String zip;

    /**
     * The no argument constructor for the SimpleAddress class.
     */
    public SimpleAddress() {
    }

    /**
     * The getCity getter for the city property.
     * 
     * @return String The city property.
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     * The getState property for the state property.
     * 
     * @return String The state property.
     */
    @Override
    public String getState() {
        return this.state;
    }

    /**
     * The getStreetAddress getter for the address property.
     * 
     * @return String The address property.
     */
    @Override
    public String getStreetAddress() {
        return this.address;
    }

    /**
     * The getZipCode getter for the zip property.
     * 
     * @return String The zip property.
     */
    @Override
    public String getZipCode() {
        return this.zip;
    }

    /**
     * The setCity setter for the city property.
     * 
     * @param city The city to be set.
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The setState setter for the state property.
     * 
     * @param state The state to be set.
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }

    /**
     * The setStreetAddress for the address property.
     * 
     * @param streetAddress The address to be set.
     */
    @Override
    public void setStreetAddress(String streetAddress) {
        this.address = streetAddress;
    }

    /**
     * The setZipCode setter for the zip property.
     * 
     * @param zip The zip code to be set.
     */
    @Override
    public void setZipCode(String zip) {
        this.zip = zip;
    }

}
