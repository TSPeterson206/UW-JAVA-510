package edu.uw.cp520.example;

import java.util.Objects;

/**
 * This is the PersonalName class. It is used to define the personal name of the
 * consultant for which an invoice of services rendered is generated.
 * 
 * @author Toby Peterson.
 *
 */
public final class PersonalName {

    /**
     * The firstName property for the PersonalName class.
     */
    private String firstName;

    /**
     * The middleName property for the PersonalName class.
     */
    private String middleName;

    /**
     * The lastName property for the PersonalName class.
     */
    private String lastName;

    /**
     * The default constructor for the PersonalName class. It takes in no
     * parameters.
     */
    PersonalName() {
        this("mylastname", "myfirstname", "mymiddlename");
    };

    /**
     * The two-parameter constructor for the PersonalName class.
     * 
     * @param lastName  The last name to be assigned to the created instance.
     * @param firstName The first name to be assigned to the created instance.
     */
    PersonalName(String lastName, String firstName) {
        this(lastName, firstName, "mymiddlename");
        setFirstName(firstName);
        setLastName(lastName);
    };

    /**
     * The three-parameter constructor for the PersonalName class.
     * 
     * @param lastName   The last name to be assigned to the created instance.
     * @param firstName  The first name to be assigned to the created instance.
     * @param middleName The middle name to be assigned to the created instance.
     */
    PersonalName(String lastName, String firstName, String middleName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    };

    /**
     * The equals method for the PersonalName class. It can compare this object
     * with another object and determine if they are equal. It returns a boolean
     * value.
     * 
     * @param other An object to be used for comparison.
     * @return boolean A boolean value that determines if the two objects are
     *         equal.
     */
    public boolean equals(Object other) {
        boolean result = false;
        if (other == null)
            result = false;
        else if (this == other)
            result = true;
        else if (this.getClass() != other.getClass())
            result = false;
        else {
            PersonalName that = (PersonalName) other;
            if (this.getFirstName() != that.getFirstName())
                ;
            else if (this.getMiddleName() != that.getMiddleName())
                ;
            else if (this.getLastName() != that.getLastName())
                ;
            else {
                result = true;
            }
        }
        return result;
    };

    /**
     * The getter for the first name property.
     * 
     * @return String A first name of a consultant in human-readable format.
     */
    public String getFirstName() {
        return this.firstName;
    };

    /**
     * The getter for the last name property.
     * 
     * @return String A last name of a consultant in human-readable format.
     */
    public String getLastName() {
        return this.lastName;
    };

    /**
     * The getter for the middle name property.
     * 
     * @return String A middle name of a consultant in human-readable format.
     */
    public String getMiddleName() {
        return this.middleName;
    };

    /**
     * The hashCode method for the PersonalName class. It returns a hash that
     * represents the value of the combined contents of this object.
     * 
     * @return int The hashed value of this object's properties.
     */
    public int hashCode() {
        int hash = Objects.hash(getFirstName(), getMiddleName(), getLastName());
        return hash;
    };

    /**
     * The setter for the firstName property.
     * 
     * @param firstName A string that represents the first name for the
     *                  consultant.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    };

    /**
     * The setter for the lastName property.
     * 
     * @param lastName A string that represents the last name for the
     *                 consultant.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    };

    /**
     * The setter for the middleName property.
     * 
     * @param middleName A string that represents the middle name for the
     *                   consultant.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    };

    /**
     * The toString method for the PersonalName class. It outputs a
     * human-readable string representing the first, middle and last names of
     * the consultant.
     * 
     * @return String The name of the consultant in string in the format //
     *         "LastName, FirstName MiddleName".
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLastName()).append(", ").append(getFirstName()).append(" ")
            .append(getMiddleName());
        return sb.toString();
    };
}
