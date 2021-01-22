package com.scg.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConsultantTest {

    @Test
    void names() {
        PersonalName name = new PersonalName("Thoreau", "Henry", "David");
        Consultant consultant = new Consultant(name);
        assertEquals(consultant.getName().toString(), "Thoreau, Henry David");
    }

    @Test
    void toStringTest() {
        PersonalName name = new PersonalName("Emerson", "Ralph", "Waldo");
        Consultant consultant = new Consultant(name);
        assertEquals(consultant.toString(), "Emerson, Ralph Waldo");
    }
}
