package edu.uw.cp520.example;

/**
 * The Consultant class for the invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class Consultant {

    /**
     * The name property of the consultant.
     */
    private PersonalName name;

    /**
     * The one-parameter constructor for the Consultant class.
     * 
     * @param name The name to be assigned to the name property.
     */
    Consultant(PersonalName name) {
        this.name = name;
    };

    /**
     * The getName method for the Consultant class.
     * 
     * @return PersonalName The human-readable name of the consultant being
     *         referenced by this class.
     */
    public PersonalName getName() {
        return this.name;
    };

    /**
     * The toString method for the Consultant class.
     * 
     * @return String The string representation of the consultant name.
     */
    public String toString() {
        return name.toString();
    };
}
