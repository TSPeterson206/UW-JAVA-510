package app;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.ext.util.ListFactory;

/**
 * The InitLists class for the serialization portion of the Invoice/TimeCard
 * project.
 * 
 * @author Toby Peterson.
 *
 */
public class InitLists {

    /** Character encoding to use. */
    private static final String ENCODING = "ISO-8859-1";

    /** This class' logger. */
    private static final Logger log = LoggerFactory.getLogger(InitLists.class);

    /**
     * cd c The main method for the InitLists class.
     * 
     * @param args The arguments being used for the main method.
     */
    public static void main(String[] args) {

        // Create lists to be populated by factory
        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        log.info("These are the serialized consultants: " + consultants);
        // Print them
//        ListFactory.printTimeCards(timeCards);

        // Use the list util methods
        Console console = System.console();
//        Consultant carl = consultants.get(0);
//        final List<TimeCard> selected = TimeCardListUtil
//            .getTimeCardsForConsultant(timeCards, carl);
//        final int count = selected.size();
////            consoleWrtr.printf("Counted %d time cards for %s%n", count, carl);
//        if (count != 2) {
//            log.error(String.format("Bad time card count for %s", carl));
//        }

//        consultants.clear();

        // Create the Invoices
//        final List<Invoice> invoices = ListFactory.createInvoices(accounts,
//            timeCards);

        // **** POPULATING TIMECARD LIST file with serialized info
        try {
            FileOutputStream fileOut = new FileOutputStream(
                "resources/TimeCardList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(timeCards);
            out.close();
            fileOut.close();
            System.out.printf(
                "Serialized data is saved in resources/TimeCardList.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // **** POPULATING CLIENTLIST file with serialized info
        try {
            FileOutputStream fileOut = new FileOutputStream(
                "resources/ClientList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accounts);
            out.writeObject(consultants);
            out.close();
            fileOut.close();
            System.out
                .printf("Serialized data is saved in resources/ClientList.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//class Student implements Serializable{
//  String name="John";
//}
//class Employee implements Serializable{
//  int age=23;
//}
//class Car implements Serializable{
//  int wheels=4;
//}
//class SerializationExample {
//  public static void main(String args[]) throws Exception {
//        Student student = new Student();
//        Employee employee = new Employee();
//        Car car = new Car();
//        
//        System.out.println("Serialization started");
//        FileOutputStream fos = new FileOutputStream("test.ser");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(student);
//        oos.writeObject(employee);
//        oos.writeObject(car);
//        System.out.println("Serialization ended");
//        
//        System.out.println("Deserialization started");
//        FileInputStream fis = new FileInputStream("test.ser");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        
//        Student stu = (Student) ois.readObject();
//        Employee emp = (Employee) ois.readObject();
//        Car c = (Car) ois.readObject();
//        
//        System.out.println("Deserialization ended");
//        
//        System.out.println("name: " + stu.name);
//        System.out.println("age: " + emp.age);
//        System.out.println("c: " + c.wheels);
//    }
//}
