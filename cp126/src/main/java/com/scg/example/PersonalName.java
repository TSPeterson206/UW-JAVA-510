package com.scg.example;

import java.util.Objects;

public final class PersonalName {

    String firstName;

    String middleName;

    String lastName;

    PersonalName() {
    };

//    Creates a new instance of Name
    PersonalName(String lastName, String firstName) {
        setFirstName(firstName);
        setLastName(lastName);
    };

//    Construct a PersonalName.
    PersonalName(String lastName, String firstName, String middleName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    };

//    Construct a PersonalName.
    public boolean equals(Object other) {
        boolean result = false;
        if (other == null)
            result = false;
        else if (this == other)
            result = true;
        else if (this.getClass() != other.getClass())
            result = false;
        else {
        }
        return result;
    };

//    Compare names for equivalence.
    public String getFirstName() {
        return this.firstName;
    };

//    Getter for firstName property.
    public String getLastName() {
        return this.lastName;
    };

//    Getter for lastName property.
    public String getMiddleName() {
        return this.middleName;
    };

//    Getter for middleName property.
    public int hashCode() {
        int hash = Objects.hash(getFirstName(), getMiddleName(), getLastName());
        return hash;
    };

//    Calculate the hash code.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    };

//    Setter for firstName property.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    };

//    Setter for lastName property.
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    };

//    Setter for middleName property.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLastName()).append(", ").append(getFirstName()).append(" ")
            .append(getMiddleName());
        return sb.toString();
    };
//    Create string representation of this object in the format
//    "LastName, FirstName MiddleName".
}
