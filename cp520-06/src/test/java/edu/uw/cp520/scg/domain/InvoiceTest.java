package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

public class InvoiceTest {

//    public Invoice(ClientAccount client, Month invoiceMonth, int invoiceYear)

    PersonalName name;
    Consultant consultant;
    LocalDate newDate;
    TimeCard tc;
    List<ConsultantTime> time;
    ClientAccount account;
    LocalDate startDate;
    ConsultantTime conTime;
    ConsultantTime conTime2;
    ConsultantTime conTime3;
    ConsultantTime conTime4;
    ConsultantTime conTime5;
    ConsultantTime conTime6;
    ConsultantTime conTime7;
    ConsultantTime conTime8;
    NonBillableAccount nonBill;
    Invoice invoice;

    @BeforeEach
    void premise() {
        name = new PersonalName("Thoreau", "Henry", "David");
        consultant = new Consultant(name);
        newDate = LocalDate.of(2020, 11, 3);
        tc = new TimeCard(consultant, newDate);
        time = new ArrayList<ConsultantTime>();
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        account = new ClientAccount("Microsoft",
            new PersonalName("Gates", "William", "Marion"), address);
        startDate = LocalDate.of(2020, 11, 3);
        nonBill = NonBillableAccount.SICK_LEAVE;
        conTime = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime2 = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime3 = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime4 = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime5 = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime6 = new ConsultantTime(startDate, nonBill,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime7 = new ConsultantTime(startDate, account,
            Skill.SOFTWARE_ENGINEER, 8);
        conTime8 = new ConsultantTime(startDate, nonBill,
            Skill.SOFTWARE_ENGINEER, 8);

        tc.addConsultantTime(conTime);
        tc.addConsultantTime(conTime2);
        tc.addConsultantTime(conTime3);
        tc.addConsultantTime(conTime4);
//        tc.addConsultantTime(conTime5);
//        tc.addConsultantTime(conTime6);
//        tc.addConsultantTime(conTime7);
//        tc.addConsultantTime(conTime8);

        invoice = new Invoice(account, Month.NOVEMBER, 2020);
        invoice.extractLineItems(tc);
    }

    @Test
    void getClientAccountTest() {
        assertEquals("Microsoft", invoice.getClientAccount().getName());
    }

    @Test
    void getInvoiceMonthTest() {
        assertEquals("NOVEMBER", invoice.getInvoiceMonth().toString());

    }

    @Test
    void getStartDateTest() {
        assertEquals("2020-11-03", invoice.getStartDate().toString());

    }

    @Test
    void getTotalChargesTest() {
        assertEquals(4800, invoice.getTotalCharges());

    }

    @Test
    void getTotalHours() {
        assertEquals(32, invoice.getTotalHours());

    }

    @Test
    void toReportStringTest() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();

        String output = "\n" + "The Small Consulting Group  \n"
            + "1616 Index Ct.              \n" + "Renton, WA 98058\n" + "\n"
            + "Invoice For:                \n" + "Microsoft\n" + "123 main st\n"
            + "seattle, WA 98116\n" + "Gates, William Marion\n" + "\n"
            + "Invoice For Month of: NOVEMBER 2020\n" + "Invoice Date: "
            + dtf.format(now) + "\n" + "\n"
            + "Date        Consultant                   Skill                Hours  Charge\n"
            + "----------  ---------------------------  ------------------   -----  ----------\n"
            + "2020-11-03  Thoreau, Henry David              Software Engineer     8      1200\n"
            + "2020-11-03  Thoreau, Henry David              Software Engineer     8      1200\n"
            + "2020-11-03  Thoreau, Henry David              Software Engineer     8      1200\n"
            + "2020-11-03  Thoreau, Henry David              Software Engineer     8      1200\n"
            + "\n"
            + "Total:                                                         32       4800\n"
            + "\n" + "\n"
            + "The Small Consulting Group                                             Page 1\n"
            + "===============================================================================";
        assertEquals(output, invoice.toReportString());
    }

    @Test
    void toStringTest() {
        String output = "this is the invoice toString. It contains the following properties: Microsoft, NOVEMBER, 2020-11-03, 32, 4800";
        assertEquals(output, invoice.toString());
    }

}
