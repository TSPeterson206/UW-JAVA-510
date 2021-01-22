package edu.uw.cp520.scg.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.uw.cp520.scg.util.PersonalName;

class ClientAccountTest {

    @Test
    void contactsGetAndSet() {
        PersonalName contact1 = new PersonalName("Gates", "William", "Marion");
        PersonalName contact2 = new PersonalName("Allen", "Paul", "Francis");
        ClientAccount account = new ClientAccount("Microsoft", contact1);

        assertEquals(account.getContact().toString(), contact1.toString());
        account.setContact(contact2);
        assertEquals(account.getContact().toString(), contact2.toString());
    }

    @Test
    void names() {
        PersonalName contact1 = new PersonalName("Job", "Steve", "Eubanks");
        ClientAccount account = new ClientAccount("Apple", contact1);
        assertEquals(account.getName().toString(), "Apple");
    }

    @Test
    void billable() {
        PersonalName contact1 = new PersonalName("Musk", "Elon", "Alabaster");
        ClientAccount account = new ClientAccount("Tesla", contact1);
        assertEquals(account.isBillable(), true);
    }

}
