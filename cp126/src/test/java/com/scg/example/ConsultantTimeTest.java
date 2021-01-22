package com.scg.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

//import edu.uw.cp520.scg.domain.ClientAccount;

class ConsultantTimeTest {

    ClientAccount account = new ClientAccount("Microsoft",
        new PersonalName("Gates", "William", "Marion"));
    LocalDate startDate = LocalDate.of(2020, 11, 5);
    ConsultantTime conTime = new ConsultantTime(startDate, account,
        Skill.SOFTWARE_ENGINEER, 8);

    @Test
    void getSkill() {
        assertEquals("Software Engineer", conTime.getSkill().toString());
    }

    @Test
    void setAndGetHours() {
        conTime.setHours(6);
        assertEquals(6, conTime.getHours());
    }

    @Test
    void setAndGetAccount() {
        PersonalName contact1 = new PersonalName("Gates", "William", "Marion");
        ClientAccount account2 = new ClientAccount("Microsoft", contact1);
        conTime.setAccount(account2);
        assertEquals(account2, conTime.getAccount());
    }

    @Test
    void setAndGetDate() {
        LocalDate newDate = LocalDate.of(2019, 10, 3);
        conTime.setDate(newDate);
        assertEquals(newDate, conTime.getDate());

    }

    @Test
    void equalsTest() {
        LocalDate newDate = LocalDate.of(2019, 10, 3);
        ClientAccount account2 = new ClientAccount("Apple",
            new PersonalName("Jobs", "Steve", "Wilhelm"));

        ConsultantTime conTime2 = new ConsultantTime(newDate, account2,
            Skill.PROJECT_MANAGER, 5);

        ConsultantTime conTime3 = new ConsultantTime(newDate, null,
            Skill.PROJECT_MANAGER, 5);

        ConsultantTime conTime4 = new ConsultantTime(newDate, null,
            Skill.PROJECT_MANAGER, 5);

        ConsultantTime conTime6 = new ConsultantTime(null, account2,
            Skill.PROJECT_MANAGER, 5);

        assertEquals(conTime, conTime);
        assertFalse(conTime.equals(null));

        assertFalse(conTime.equals(account2));
        assertFalse(conTime.equals(conTime2));

        assertFalse(conTime.equals(conTime2));
        assertFalse(conTime3.equals(conTime2));
        assertTrue(conTime3.equals(conTime4));
        assertTrue(conTime3.equals(conTime4));
        assertFalse(conTime4.equals(conTime6));
        assertFalse(conTime2.equals(conTime6));
        assertFalse(conTime6.equals(conTime2));
        assertFalse(conTime2.equals(conTime4));

    }

    @Test
    void hashCodeTest() {
        LocalDate newDate = LocalDate.of(2019, 10, 3);
        ConsultantTime conTime3 = new ConsultantTime(newDate, null,
            Skill.PROJECT_MANAGER, 5);
//        assertEquals(-248187896, conTime3.hashCode());
    }

    @Test
    void isBillableTest() {
        assertEquals(true, conTime.isBillable());
        assertTrue(conTime.isBillable() == true);
        assertFalse(conTime.isBillable() == false);
    }
}
