package edu.uw.cp520.scg.domain;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * The Invoice class for the Invoice/TimeCard project. This class contains the
 * necessary properties and methods to compile and print an invoice.
 * 
 * @author Toby Peterson.
 *
 */
public class Invoice implements java.io.Serializable {

    /**
     * The client property for the Invoice class.
     */
    private ClientAccount client;
    /**
     * The invoiceMonth property for the Invoice class.
     */
    private Month invoiceMonth;
    /**
     * The invoiceYear property for the Invoice class.
     */
    @SuppressWarnings("unused")
    private int invoiceYear;
    /**
     * The startingDay property for the Invoice class.
     */
    private LocalDate startingDay;
    /**
     * The lineItems property for the Invoice class.
     */
    private List<InvoiceLineItem> lineItems = new ArrayList<InvoiceLineItem>();
    /**
     * The totalHours property for the Invoice class.
     */
    private int totalHours;
    /**
     * The totalCharges property for the Invoice class.
     */
    private int totalCharges;

    /**
     * The 3-parameter constructor for the InvoiceClass.
     * 
     * @param client       The ClientAccount being used to build the invoice
     *                     entry.
     * @param invoiceMonth The month that this invoice is scoped to.
     * @param invoiceYear  The year that this invoice is scoped to.
     */
    public Invoice(ClientAccount client, Month invoiceMonth, int invoiceYear) {
        this.client = client;
        this.invoiceMonth = invoiceMonth;
        this.invoiceYear = invoiceYear;

        YearMonth ym = YearMonth.of(invoiceYear, invoiceMonth);
        startingDay = ym.atDay(1);
//        startingDay = cal.getActualMinimum(Calendar.DATE);
//        invoiceYear = tc.getDate().getYear();
    }

    /**
     * The addLineItem method for the invoice class. It is used to add line
     * items to an arraylist of lineItems
     * 
     * @param lineItem The InvoiceLineItem being added to the arraylist.
     */
    public void addLineItem(InvoiceLineItem lineItem) {
        totalHours += lineItem.getHours();
        totalCharges += lineItem.getCharges();
        lineItems.add(lineItem);
    }

    /**
     * The extractLineItems method for the Invoice class. It is used to scope
     * the invoice to a particular month and get the billable hours for a
     * particular client.
     * 
     * @param timeCard The TimeCard being used in order to grab the billable
     *                 hours and other components.
     */
    public void extractLineItems(TimeCard timeCard) {
        List<ConsultantTime> timeCardList = timeCard
            .getBillableHoursForClient(client.getName());

        InvoiceLineItem lineItem;

        List<ConsultantTime> timeCardsWithinMonth = timeCardList.stream()
            .filter(tc -> tc.getDate().getMonth() == invoiceMonth)
            .collect(Collectors.toList());

        for (ConsultantTime tc : timeCardsWithinMonth) {
//            startingDay = tc.getDate();
//            invoiceYear = tc.getDate().getYear();
            lineItem = new InvoiceLineItem(tc.getDate(),
                timeCard.getConsultant(), tc.getSkill(), tc.getHours());
            addLineItem(lineItem);
        }
    }

    /**
     * The getClientAccount getter for the Invoice class.
     * 
     * @return client The client property.
     */
    public ClientAccount getClientAccount() {
        return client;
    }

    /**
     * The getInvoiceMonth getter for the Invoice class.
     * 
     * @return invoiceMonth The invoiceMonth property.
     */
    public Month getInvoiceMonth() {
        return invoiceMonth;
    }

    /**
     * The getStartDate getter method for the Invoice class.
     * 
     * @return startingDay The startingDay property.
     */
    public LocalDate getStartDate() {
        return startingDay;
    }

    /**
     * The getTotalCharges getter for the Invoice class.
     * 
     * @return totalCharges The totalCharges property.
     */
    public int getTotalCharges() {
        return totalCharges;
    }

    /**
     * The getTotalHours getter for the Invoice class.
     * 
     * @return totalHours The totalHours property.
     */
    public int getTotalHours() {
        return totalHours;
    }

    /**
     * The toReportString method for the Invoice class.
     * 
     * @return String The output for the invoice. This is a human-readable
     *         series of strings that is the totality of all the components of
     *         the Invoice class.
     */
    @SuppressWarnings("unused")
    public String toReportString() {
        Properties properties = null;

        try {
            properties = new Properties();
            InputStream resourceAsStream = Invoice.class.getClassLoader()
                .getResourceAsStream("invoice.properties");
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();
        String name = properties.getProperty("business.name");
        String street = properties.getProperty("business.street");
        String city = properties.getProperty("business.city");
        String state = properties.getProperty("business.state");
        String zip = properties.getProperty("business.zip");
        int page = 0;

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb, Locale.US);

        List<InvoiceLineItem> lineItemsClone = new ArrayList<InvoiceLineItem>();

        InvoiceHeader header = new InvoiceHeader(getClientAccount().getName(),
            getClientAccount().getAddress(), getClientAccount(), startingDay,
            startingDay);
        InvoiceFooter footer = new InvoiceFooter(name);

        int loopCounterBig = 1;
        for (int i = 0; i < loopCounterBig; i++) {
            page++;

            fm.format("%n%-28s%n", name).format("%-28s%n", street)
                .format("%1$s, %2$s %3$s%n%n", city, state, zip)
                .format("%-28s%n", "Invoice For:")

                .format(header.toString())

                .format("%n%n%1$s %2$17s %3$23s %4$20s %5$7s%n"
                    + "----------  ---------------------------  ------------------   -----  ----------%n",
                    "Date", "Consultant", "Skill", "Hours", "Charge");

            int loopCounterSmall = 0;
            boolean end = false;

            lineItemsClone = lineItems;
            if (lineItems.size() <= 5) {
                end = true;
            }

            for (InvoiceLineItem item : lineItems) {

                fm.format(item.toString());

                loopCounterSmall++;
                if (loopCounterSmall == 5) {
                    lineItems = lineItems.subList(5, lineItems.size());
                    loopCounterSmall = 0;
                    loopCounterBig++;
                    break;
                }
                ;
            }

            if (end == true) {
                fm.format("%n%-28s %2$36s %3$10s%n%n%n", "Total:",
                    getTotalHours(), getTotalCharges());
            } else {
                fm.format("%n%n%n");
            }
            ;

            fm.format(footer.toString());
            footer.incrementPageNumber();

            fm.format(
                "%n===============================================================================");

        }
        String output = fm.toString();
        fm.close();
        return output;
    }

    /**
     * The toString method for the Invoice class.
     * 
     * @return String The basic output of the Invoice class, used for testing
     *         the validity of the class.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
            "this is the invoice toString. It contains the following properties: ")
            .append(getClientAccount().getName()).append(", ")
            .append(getInvoiceMonth()).append(", ").append(getStartDate())
            .append(", ").append(getTotalHours()).append(", ")
            .append(getTotalCharges());
        return sb.toString();
//        return toReportString();
    }
}