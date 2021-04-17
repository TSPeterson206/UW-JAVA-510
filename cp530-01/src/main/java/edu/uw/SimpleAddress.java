package edu.uw;

import edu.uw.ext.framework.account.Address;

public class SimpleAddress implements Address {

    private String city;
    private String state;
    private String address;
    private String zip;

    public SimpleAddress() {
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getStreetAddress() {
        return this.address;
    }

    @Override
    public String getZipCode() {
        return this.zip;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setStreetAddress(String streetAddress) {
        this.address = streetAddress;
    }

    @Override
    public void setZipCode(String zip) {
        this.zip = zip;
    }

}
