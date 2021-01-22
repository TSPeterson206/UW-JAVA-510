package com.scg.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PersonalNameTest {

    @Test
    void equalsTest() {
        PersonalName name1 = new PersonalName("Herscheiser", "Orel");
        PersonalName name2 = new PersonalName("McGwire", "Mark");
        PersonalName name3 = new PersonalName("Herscheiser", "Orel");
        Consultant consultant = new Consultant(name2);

        assertFalse(name1.equals(null));
        assertFalse(name1.equals(consultant));
        assertFalse(name1.equals(name2));
        assertTrue(name1.equals(name3));
        assertTrue(name1.equals(name1));

        name1.setLastName("Peterson");
        assertFalse(name1.equals(name3));
        name1.setLastName("Herscheiser");
        assertTrue(name1.equals(name3));
        name1.setMiddleName("Brodie");
        assertFalse(name1.equals(name3));
    }

    @Test
    void nameGetAndSet() {
        PersonalName name1 = new PersonalName("Puckett", "Kirby");
        PersonalName name2 = new PersonalName("Clements", "Roger", "Warren");
        PersonalName name3 = new PersonalName();

        assertEquals(name1.getFirstName(), "Kirby");
        assertEquals(name2.getFirstName(), "Roger");
        assertEquals(name3.getFirstName(), "myfirstname");
        assertEquals(name1.getMiddleName(), "mymiddlename");
        assertEquals(name2.getMiddleName(), "Warren");
        assertEquals(name3.getMiddleName(), "mymiddlename");
        assertEquals(name1.getLastName(), "Puckett");
        assertEquals(name2.getLastName(), "Clements");
        assertEquals(name3.getLastName(), "mylastname");

        name1.setFirstName("Larry");
        name2.setFirstName("Moe");
        name3.setFirstName("Curly");

        assertEquals(name1.getFirstName(), "Larry");
        assertEquals(name2.getFirstName(), "Moe");
        assertEquals(name3.getFirstName(), "Curly");

        name1.setMiddleName("George");
        name2.setMiddleName("John");
        name3.setMiddleName("Paul");

        assertEquals(name1.getMiddleName(), "George");
        assertEquals(name2.getMiddleName(), "John");
        assertEquals(name3.getMiddleName(), "Paul");

        name1.setLastName("Simpson");
        name2.setLastName("Griffin");
        name3.setLastName("Boyd");

        assertEquals(name1.getLastName(), "Simpson");
        assertEquals(name2.getLastName(), "Griffin");
        assertEquals(name3.getLastName(), "Boyd");
    }

    @Test
    void hashCodeTest() {
        PersonalName name1 = new PersonalName("Canseco", "Jose");
        assertEquals(1397498936, name1.hashCode());
    }

    @Test
    void toStringTest() {
        PersonalName name1 = new PersonalName("Ramirez", "Manny");
        assertEquals(name1.toString(), "Ramirez, Manny mymiddlename");
    }
}
