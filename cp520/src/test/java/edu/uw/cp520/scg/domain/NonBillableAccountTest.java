package edu.uw.cp520.scg.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class NonBillableAccountTest {

    NonBillableAccount NonBillableAccount1 = NonBillableAccount.SICK_LEAVE;
    NonBillableAccount NonBillableAccount2 = NonBillableAccount.VACATION;
    NonBillableAccount NonBillableAccount3 = NonBillableAccount.BUSINESS_DEVELOPMENT;

    @Test
    void constructorTest() {

    }

    @Test
    void names() {

        assertEquals(NonBillableAccount1.getName(), "Sick Leave");
        assertEquals(NonBillableAccount2.getName(), "Vacation");
        assertEquals(NonBillableAccount3.getName(), "Business Development");
    }

    @Test
    void isBillable() {
        assertEquals(NonBillableAccount1.isBillable(), false);
        assertEquals(NonBillableAccount2.isBillable(), false);
        assertEquals(NonBillableAccount3.isBillable(), false);
    }
}
