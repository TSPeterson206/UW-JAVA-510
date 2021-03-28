package edu.uw.cp520.scg.domain;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uw.cp520.scg.util.PersonalName;

/**
 * The Consultant class for the invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class Consultant
    implements Comparable<Consultant>, java.io.Serializable {

    /**
     * The name property of the consultant.
     */
    private PersonalName name;

    private static final Logger log = LoggerFactory.getLogger(Consultant.class);

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

    /**
     * The writeReplace method for the Consultant class. This
     * 
     * @return Object The proxy-serialized instance of the class.
     */
    private Object writeReplace() {
        final String message = String
            .format("This is one of the serialized consultants: %s", getName());
        log.info(message);
        return new SerializationProxy(this);
    }

    /**
     * The readObject method for the Consultant class.
     * 
     * @param stream The stream passed as an argument.
     * @throws InvalidObjectException
     */
    private void readObject(ObjectInputStream stream)
        throws InvalidObjectException {
        throw new InvalidObjectException("Use Serialization Proxy instead.");
    }

    /**
     * The SerializationProxy inner class.
     * 
     * @author Toby Peterson.
     *
     */
    private static class SerializationProxy implements Serializable {

        private PersonalName name;

        public SerializationProxy(Consultant consultant) {
            this.name = consultant.getName();
        }

        private Object readResolve() {
            final String message = String.format(
                "This is one of the DEserialized consultants: %s",
                new Consultant(name));
            log.info(message);
            return new Consultant(name);
        }
    }
}
