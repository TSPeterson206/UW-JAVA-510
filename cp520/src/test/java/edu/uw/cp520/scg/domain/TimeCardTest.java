package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.PersonalName;

class TimeCardTest {

    PersonalName name;
    Consultant consultant;
    LocalDate newDate;
    TimeCard tc;
    List<ConsultantTime> time;
    ClientAccount account;
    LocalDate startDate;
    ConsultantTime conTime;
    ConsultantTime conTime2;

    NonBillableAccount nonBill;

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
        nonBill = NonBillableAccount.SICK_LEAVE;
        conTime2 = new ConsultantTime(startDate, nonBill,
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
        tc.addConsultantTime(conTime);
        String billable = "";
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
        String output = "====================================================================\n"
            + "Consultant: Thoreau, Henry David         Week Starting: Oct 3, 2019\n"
            + "Billable Time:\n"
            + "Account                      Date        Hours  Skill\n"
            + "---------------------------  ----------  -----  --------------------\n"
            + "Microsoft                    11/05/2020      8 Software Engineer\n"
            + "\n" + "Non-billable Time:\n"
            + "Account                      Date        Hours  Skill\n"
            + "---------------------------  ----------  -----  --------------------\n"
            + "Sick Leave                   11/05/2020      8 Software Engineer\n"
            + "\n" + "Summary:\n"
            + "Total Billable:                             8\n"
            + "Total Non-Billable:                         8\n"
            + "Total Hours:                               16\n"
            + "====================================================================";

        tc.addConsultantTime(conTime);
        tc.addConsultantTime(conTime2);
        assertEquals(output, tc.toReportString());
    }

    @Test
    void toStringTest() {

        assertEquals(
            "TimeCard for: Thoreau, Henry David, Week Starting: Oct 3, 2019",
            tc.toString());
    }

}
