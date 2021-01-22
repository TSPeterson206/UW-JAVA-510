package edu.uw.cp520.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.example.ClientAccount;
import edu.uw.cp520.example.Consultant;
import edu.uw.cp520.example.ConsultantTime;
import edu.uw.cp520.example.PersonalName;
import edu.uw.cp520.example.Skill;
import edu.uw.cp520.example.TimeCard;

class TimeCardTest {

    PersonalName name;
    Consultant consultant;
    LocalDate newDate;
    TimeCard tc;
    List<ConsultantTime> time;
    ClientAccount account;
    LocalDate startDate;
    ConsultantTime conTime;

    @BeforeEach
    void test() {
        name = new PersonalName("Thoreau", "Henry", "David");
        consultant = new Consultant(name);
        newDate = LocalDate.of(2019, 10, 3);
        tc = new TimeCard(consultant, newDate);
//        System.out.println("*******" + tc.getConsultant().getName());
        time = new ArrayList<ConsultantTime>();

        account = new ClientAccount("Microsoft",
            new PersonalName("Gates", "William", "Marion"));
        startDate = LocalDate.of(2020, 11, 5);
        conTime = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
    }

    @Test
    void addConsultantTimeTest() {
        tc.addConsultantTime(conTime);
        assertEquals(1, tc.getConsultingHours().size());
    }

    @Test
    void getTotalBillableTest() {
        tc.addConsultantTime(conTime);
        assertEquals(8, tc.getTotalBillableHours());
    }

    @Test
    void getBillableHoursForClientTest() {
        String billable = "";
        tc.addConsultantTime(conTime);
        for (ConsultantTime item : time) {
            if (item.isBillable() == true) {
                billable += item.getAccount().getName();
            }
            ;
        }
        assertEquals(new ArrayList<ConsultantTime>().getClass(),
            tc.getBillableHoursForClient("Microsoft").getClass());

    }

    @Test
    void getTotalNonBillableTest() {
        tc.addConsultantTime(conTime);
        assertEquals(0, tc.getTotalNonBillableHours());
    }

    @Test
    void getTotalConsultingHoursTest() {
        tc.addConsultantTime(conTime);
        assertEquals(new ArrayList<ConsultantTime>().getClass(),
            tc.getConsultingHours().getClass());
        assertEquals(1, tc.getConsultingHours().size());
    }

    @Test
    void getTotalHoursTest() {
        tc.addConsultantTime(conTime);
        assertEquals(8, tc.getTotalHours());
    }

    @Test
    void getWeekStartingDayTest() {
        tc.addConsultantTime(conTime);
        assertEquals("2019-10-03", tc.getWeekStartingDay().toString());
    }

    @Test
    void getConsultantTest() {
        assertEquals(name.toString(), tc.getConsultant().toString());
    }

    @Test
    void toReportStringTest() {
        tc.addConsultantTime(conTime);
        assertEquals("test to report string", tc.toReportString());
    }

}
