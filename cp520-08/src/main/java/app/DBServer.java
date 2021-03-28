package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.ConsultantTime;
import edu.uw.cp520.scg.domain.Invoice;
import edu.uw.cp520.scg.domain.InvoiceLineItem;
import edu.uw.cp520.scg.domain.Skill;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

/**
 * The DBServer class for the timecard/invoice class.
 * 
 * @author Toby Peterson.
 *
 */
public class DBServer {

    /**
     * The dbUrl property.
     */
    String dbUrl;

    /**
     * The username property.
     */
    String username;

    /**
     * The password property.
     */
    String password;

    /**
     * The conn/connection property.
     */
    private Connection conn = null;

    /**
     * The constructor for the DBServer class.
     * 
     * @param dbUrl    The url used for the database server.
     * @param username The username used for the connection to the database
     *                 server.
     * @param password The password used for the connection to the database
     *                 server.
     */
    DBServer(String dbUrl, String username, String password) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The addClient method for the DBServer class.
     * 
     * @param client The client object passed in in order to be added to the
     *               database.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     */
    public void addClient​(ClientAccount client) throws SQLException {
        Statement stmt = conn.createStatement();

        String addClientString = "INSERT INTO clients (name, street, city, state, postal_code, contact_last_name, contact_first_name, contact_middle_name)VALUES ("
            + "'" + client.getName().toString() + "'" + "," + "'"
            + client.getAddress().getStreetNumber().toString() + "'" + "," + "'"
            + client.getAddress().getCity().toString() + "'" + "," + "'"
            + client.getAddress().getState().toString() + "'" + "," + "'"
            + client.getAddress().getPostalCode().toString() + "'" + "," + "'"
            + client.getContact().getLastName().toString() + "'" + "," + "'"
            + client.getContact().getFirstName().toString() + "'" + "," + "'"
            + client.getContact().getMiddleName().toString() + "'" + ")";

        stmt.executeUpdate(addClientString);
    }

    /**
     * The getClients method for the DBServer class.
     * 
     * @return A list of ClientAccount objects.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     */
    public List<ClientAccount> getClients() throws SQLException {

        List<ClientAccount> clientList = new ArrayList<ClientAccount>();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(
            "SELECT name, street, city, state, postal_code, contact_last_name, contact_first_name, contact_middle_name FROM clients");

        while (rs.next()) {
            String name = rs.getString("name");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String state = rs.getString("state");
            String postalCode = rs.getString("postal_code");
            String contactLast = rs.getString("contact_last_name");
            String contactMiddle = rs.getString("contact_first_name");
            String contactFirst = rs.getString("contact_middle_name");

            PersonalName contactName = new PersonalName(contactLast,
                contactFirst, contactMiddle);

            Address address = new Address(street, city,
                StateCode.valueOf(state), postalCode);

            ClientAccount account = new ClientAccount(name, contactName,
                address);

            clientList.add(account);

        }
        return clientList;
    }

    /**
     * The addConsultant method for the DBServer class.
     * 
     * @param consultant The consultant object to be added to the database.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     */
    public void addConsultant​(Consultant consultant) throws SQLException {
        Statement stmt = conn.createStatement();

        String clientString2 = "INSERT INTO consultants (last_name, first_name, middle_name) VALUES ("
            + "'" + consultant.getName().getLastName() + "'" + "," + "'"
            + consultant.getName().getFirstName() + "'" + "," + "'"
            + consultant.getName().getMiddleName() + "'" + ")";

        stmt.executeUpdate(clientString2);
    }

    /**
     * The getConsultants method for the DBServer class.
     * 
     * @return A list of Consultant objects.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     */
    public List<Consultant> getConsultants() throws SQLException {
        List<Consultant> consultantList = new ArrayList<Consultant>();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(
            "SELECT last_name, first_name, middle_name FROM consultants");

        while (rs.next()) {
            String contactLast = rs.getString("last_name");
            String contactMiddle = rs.getString("first_name");
            String contactFirst = rs.getString("middle_name");
            PersonalName contactName = new PersonalName(contactLast,
                contactFirst, contactMiddle);
            Consultant consultant = new Consultant(contactName);

            consultantList.add(consultant);

        }
        return consultantList;
    }

    /**
     * The addTimeCard method for the DBServer class.
     * 
     * @param timeCard The TimeCard to be entered into the database.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     */
    public void addTimeCard​(TimeCard timeCard) throws SQLException {
        Statement stmt = conn.createStatement();

        String consultantId = "SELECT id FROM consultants WHERE "
            + "last_name ='" + timeCard.getConsultant().getName().getLastName()
            + "'" + " AND first_name ='"
            + timeCard.getConsultant().getName().getFirstName() + "'"
            + " AND middle_name ='"
            + timeCard.getConsultant().getName().getMiddleName() + "'";

        ResultSet id = stmt.executeQuery(consultantId);
        int eyeDee = 0;
        while (id.next()) {
            eyeDee = id.getInt("id");
        }

        String idInsert = "INSERT INTO timecards (consultant_id, start_date) VALUES ("
            + eyeDee + ", '" + timeCard.getWeekStartingDay().toString() + "')";

        stmt.executeUpdate(idInsert, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        int newId = 0;
        if (rs.next()) {
            newId = rs.getInt(1);
        }

        List<ConsultantTime> time = timeCard.getConsultingHours();

        String billInsert = null;
        String nonBillInsert = null;

        for (ConsultantTime item : time) {
            if (item.isBillable() == true) {

                billInsert = "INSERT INTO billable_hours (client_id, timecard_id, date, skill, hours) VALUES ("
                    + "(SELECT DISTINCT id FROM clients WHERE name = '"
                    + item.getAccount().getName() + "')" + "," + newId + ",'"
                    + item.getDate().toString() + "','" + item.getSkill().name()
                    + "'," + item.getHours() + ")";
                stmt.executeUpdate(billInsert);
            } else {
                nonBillInsert = "INSERT INTO non_billable_hours (account_name, timecard_id, date, hours) VALUES ("
                    + "'" + item.getAccount().toString() + "'," + newId + ",'"
                    + item.getDate().toString() + "'," + item.getHours() + ")";

                stmt.executeUpdate(nonBillInsert);
            }
        }
    }

    /**
     * The getInvoice method for the DBServer class.
     * 
     * @param client The client used to construct the invoice.
     * @param month  The month parameter for the generated invoice.
     * @param year   The year parameter for the generated invoice.
     * @return The created Invoice object.
     * @throws SQLException The exception thrown when a SQL command is invalid.
     * 
     */
    public Invoice getInvoice​(ClientAccount client, Month month, int year)
        throws SQLException {

        LocalDate start = LocalDate.of(year, month.getValue(), 1);
        LocalDate end = YearMonth.of(year, month.getValue()).atEndOfMonth();
        Invoice invoice = new Invoice(client, month, year);
        String contactLast;
        String contactMiddle;
        String contactFirst;
        Date date;
        String skill;
        int rate;
        int hours;
        InvoiceLineItem lineItem;

        Statement stmt = conn.createStatement();

        String invoiceQuery = "SELECT b.date, c.last_name, c.first_name, c.middle_name, b.skill, s.rate, b.hours FROM billable_hours b, consultants c, skills s, timecards t WHERE b.date between Date('"
            + start.toString() + "') AND Date('" + end.toString()
            + "') AND b.client_id = (SELECT DISTINCT id FROM clients WHERE name ='"
            + client.getName()
            + "') AND b.skill = s.name AND b.timecard_id = t.id AND c.id = t.consultant_id";

        ResultSet rs = stmt.executeQuery(invoiceQuery);

        while (rs.next()) {
            contactLast = rs.getString("last_name");
            contactMiddle = rs.getString("first_name");
            contactFirst = rs.getString("middle_name");
            date = rs.getObject(1, Date.class);
            skill = rs.getString("skill");
            rate = rs.getInt("rate");
            hours = rs.getInt("hours");

            PersonalName contactName = new PersonalName(contactLast,
                contactFirst, contactMiddle);

            Consultant consultant = new Consultant(contactName);

            Skill consultantSkill = Skill.valueOf(skill);

            lineItem = new InvoiceLineItem(date.toLocalDate(), consultant,
                consultantSkill, hours);

            invoice.addLineItem(lineItem);
        }
        return invoice;
    }
}
