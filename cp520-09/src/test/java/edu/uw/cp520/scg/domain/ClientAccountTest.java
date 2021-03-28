package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.uw.cp520.scg.util.Address;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;

import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

class ClientAccountTest {

    @Test
    void contactsGetAndSet() {
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        PersonalName contact1 = new PersonalName("Gates", "William", "Marion");
        PersonalName contact2 = new PersonalName("Allen", "Paul", "Francis");
        ClientAccount account = new ClientAccount("Microsoft", contact1,
            address);

        assertEquals(account.getContact().toString(), contact1.toString());
        account.setContact(contact2);
        assertEquals(account.getContact().toString(), contact2.toString());
    }

    @Test
    void names() {
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        PersonalName contact1 = new PersonalName("Job", "Steve", "Eubanks");
        ClientAccount account = new ClientAccount("Apple", contact1, address);
        assertEquals(account.getName().toString(), "Apple");
    }

    @Test
    void billable() {
        Address address = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        PersonalName contact1 = new PersonalName("Musk", "Elon", "Alabaster");
        ClientAccount account = new ClientAccount("Tesla", contact1, address);
        assertEquals(account.isBillable(), true);
    }

}
