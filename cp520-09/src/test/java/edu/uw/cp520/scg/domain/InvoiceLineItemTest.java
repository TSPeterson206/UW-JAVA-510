package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.PersonalName;

public class InvoiceLineItemTest {

    @Test
    void gettersTest() {
        LocalDate startDate = LocalDate.of(2019, 01, 13);
        PersonalName name = new PersonalName("Thoreau", "Henry", "David");
        Consultant consultant = new Consultant(name);
        InvoiceLineItem lineItem = new InvoiceLineItem(startDate, consultant,
            Skill.PROJECT_MANAGER, 8);

        assertEquals("2019-01-13", lineItem.getDate().toString());
        assertEquals("Thoreau, Henry David",
            lineItem.getConsultant().toString());
        assertEquals("Project Manager", lineItem.getSkill().toString());
        assertEquals(8, lineItem.getHours());
        assertEquals(2000, lineItem.getCharges());
    }

    @Test
    void toStringTest() {
        LocalDate startDate = LocalDate.of(2019, 01, 13);
        PersonalName name = new PersonalName("Thoreau", "Henry", "David");
        Consultant consultant = new Consultant(name);
        InvoiceLineItem lineItem = new InvoiceLineItem(startDate, consultant,
            Skill.PROJECT_MANAGER, 8);

        assertEquals(
            "2019-01-13  Thoreau, Henry David              Project Manager     8      2000\n"
                + "",
            lineItem.toString());
    }

}
