package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;

import edu.uw.cp520.scg.util.PersonalName;

class ConsultantTest {

    @Test
    void names() {
        PersonalName name = new PersonalName("Thoreau", "Henry", "David");
        Consultant consultant = new Consultant(name);
        System.out.println(consultant.getName());
        assertEquals(consultant.getName().toString(), "Thoreau, Henry David");
    }

    @Test
    void toStringTest() {
        PersonalName name = new PersonalName("Emerson", "Ralph", "Waldo");
        Consultant consultant = new Consultant(name);
        assertEquals(consultant.toString(), "Emerson, Ralph Waldo");
    }
}
