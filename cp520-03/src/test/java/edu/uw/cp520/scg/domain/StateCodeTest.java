package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.StateCode;

public class StateCodeTest {

    @Test
    void testColor() {
        assertEquals("CA", StateCode.CA.toString());
        assertEquals("WA", StateCode.WA.toString());
    }

    @Test
    void testColorSize() {
        assertEquals(2, StateCode.values().length);
    }

    @Test
    void forNameTest() {
        assertEquals("CA", StateCode.CA.forName("California").toString());
        assertEquals("WA", StateCode.WA.forName("Washington").toString());
        assertEquals("CA", StateCode.WA.forName("Oregon").toString());

    }
}
