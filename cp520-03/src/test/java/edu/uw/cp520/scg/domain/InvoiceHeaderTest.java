package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

public class InvoiceHeaderTest {

    @Test
    void toStringTest() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();

        LocalDate startDate = LocalDate.of(2019, 01, 13);
        Address address = new Address("456 Broadway", "Seattle", StateCode.WA,
            "98117");
        PersonalName contact1 = new PersonalName("Job", "Steve", "Eubanks");
        ClientAccount account = new ClientAccount("Apple", contact1, address);

        InvoiceHeader header = new InvoiceHeader("Microsoft", address, account,
            startDate, startDate);

        String output = "Microsoft\n" + "456 Broadway\n" + "Seattle, WA 98117\n"
            + "Job, Steve Eubanks\n" + "\n"
            + "Invoice For Month of: JANUARY 2019\n" + "Invoice Date: "
            + dtf.format(now);

        assertEquals(output, header.toString());
    }
}