package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import edu.uw.cp520.scg.util.Address;

//import org.junit.Test;

import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

class ConsultantTimeTest {
    Address address = new Address("123 main st", "seattle", StateCode.WA,
        "98116");
    ClientAccount account = new ClientAccount("Microsoft",
        new PersonalName("Gates", "William", "Marion"), address);
    LocalDate startDate = LocalDate.of(2020, 11, 5);
    ConsultantTime conTime = new ConsultantTime(startDate, account,
        Skill.SOFTWARE_ENGINEER, 8);

    NonBillableAccount account2 = NonBillableAccount.VACATION;

    ConsultantTime conTime2 = new ConsultantTime(startDate, account2,
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
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        PersonalName contact1 = new PersonalName("Gates", "William", "Marion");
        ClientAccount account2 = new ClientAccount("Microsoft", contact1,
            address);
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
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        LocalDate newDate = LocalDate.of(2019, 10, 3);
        ClientAccount account2 = new ClientAccount("Apple",
            new PersonalName("Jobs", "Steve", "Wilhelm"), address);

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
        ConsultantTime conTime1 = new ConsultantTime(newDate, null,
            Skill.PROJECT_MANAGER, 5);
        ConsultantTime conTime2 = new ConsultantTime(newDate, null,
            Skill.PROJECT_MANAGER, 5);

        assertEquals(conTime1.hashCode(), conTime2.hashCode());
        assertFalse(conTime1.hashCode() == conTime.hashCode());
    }

    @Test
    void isBillableTest() {
        assertEquals(true, conTime.isBillable());
        assertTrue(conTime.isBillable() == true);
        assertFalse(conTime.isBillable() == false);
        assertEquals(false, conTime2.isBillable());
    }

    @Test
    void toStringTest() {
        assertEquals(
            "ConsultantTime: Microsoft, 2020-11-05, 8, Software Engineer",
            conTime.toString());
    }

    @Test
    void exceptionsTest() {
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        ClientAccount account = new ClientAccount("Microsoft",
            new PersonalName("Gates", "William", "Marion"), address);
        LocalDate startDate = LocalDate.of(2020, 11, 5);
        ConsultantTime conTime = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);

        Assertions.assertThrows(IllegalArgumentException.class,
            new Executable() {
                public void execute() throws Throwable {
                    ConsultantTime conTime2 = new ConsultantTime(startDate,
                        account, Skill.SOFTWARE_ENGINEER, 0);
                    conTime2.getAccount();
                }
            });

        Assertions.assertThrows(IllegalArgumentException.class,
            new Executable() {
                public void execute() throws Throwable {
                    conTime.setHours(0);
                }
            });
    }
}
