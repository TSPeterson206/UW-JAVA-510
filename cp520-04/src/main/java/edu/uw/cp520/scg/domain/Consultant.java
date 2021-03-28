package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;

/**
 * The Consultant class for the invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class Consultant implements Comparable<Consultant> {

    /**
     * The name property of the consultant.
     */
    private PersonalName name;

    /**
     * The one-parameter constructor for the Consultant class.
     * 
     * @param name The name to be assigned to the name property.
     */
    public Consultant(PersonalName name) {
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
    }

    /**
     * The compareTo method for the Consultant class.
     * 
     * @param arg0 The consultant argument to be used for comparison.
     * @return int The comparison value indicating the values of this object vs
     *         a passed in argument object of the same type.
     */
    @Override
    public int compareTo(Consultant arg0) {
        int cmp = this.getName().toString()
            .compareTo(arg0.getName().toString());
        return cmp;
    };
}
