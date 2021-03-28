package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

//import cp510.assignments.assignment9.ChessColor;

public class AddressTest {

    @Test
    void gettersTest() {
        Address address = new Address("123 Main street", "Seattle",
            StateCode.WA, "98106");

        assertEquals("123 Main street", address.getStreetNumber());
        assertEquals("Seattle", address.getCity());
        assertEquals("WA", address.getState().toString());
        assertEquals("98106", address.getPostalCode());
    }

    @Test
    void equalsTest() {
        Address address = new Address("456 Broadway", "Seattle", StateCode.WA,
            "98117");

        Address address2 = new Address("123 Main street", "Seattle",
            StateCode.WA, "98106");

        Address address3 = new Address("456 Broadway", "Seattle", StateCode.WA,
            "98117");

        PersonalName name = new PersonalName("Thoreau", "Henry", "David");

        assertFalse(address.equals(address2));
        assertTrue(address.equals(address3));
        assertFalse(address.equals(name));
        assertTrue(address.equals(address));

    }

    @Test
    void hashCodeTest() {
        Address address = new Address("456 Broadway", "Seattle", StateCode.WA,
            "98117");

        Address address2 = new Address("123 Main St", "Bellevue", StateCode.WA,
            "98126");

        Address address3 = new Address("123 Main St", "Bellevue", StateCode.WA,
            "98126");

        assertEquals(address2.hashCode(), address3.hashCode());
        assertFalse(address.hashCode() == address2.hashCode());
        assertFalse(address.hashCode() == address2.hashCode());
    }

    @Test
    void toStringTest() {
        Address address = new Address("456 Broadway", "Seattle", StateCode.WA,
            "98117");
        assertEquals("456 Broadway\n" + "Seattle, WA 98117",
            address.toString());
    }
}
