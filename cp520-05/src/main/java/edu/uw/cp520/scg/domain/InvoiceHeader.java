package edu.uw.cp520.scg.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.uw.cp520.scg.util.Address;

/**
 * The InvoiceHeader class for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceHeader {
    /**
     * The businessName property.
     */
    private String businessName;

    /**
     * The businessAddress property.
     */
    private Address businessAddress;

    /**
     * The client property.
     */
    private ClientAccount client;

    /**
     * The invoiceDate property.
     */
    private LocalDate invoiceDate;

    /**
     * The invoiceForMonth property.
     */
    @SuppressWarnings("unused")
    private LocalDate invoiceForMonth;

    /**
     * The constructor for InvoiceHeader.
     * 
     * @param businessName    The business name.
     * @param businessAddress The business address.
     * @param client          The client for the invoice header.
     * @param invoiceDate     The date for the invoice header.
     * @param invoiceForMonth The month that the invoice is for.
     */
    public InvoiceHeader(String businessName, Address businessAddress,
        ClientAccount client, LocalDate invoiceDate,
        LocalDate invoiceForMonth) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.client = client;
        this.invoiceDate = invoiceDate;
        this.invoiceForMonth = invoiceForMonth;
    }

    /**
     * The toString method for the InvoiceHeader class.
     * 
     * @return String The human-readable string for the InvoiceHeader.
     * 
     */
    @Override
    public String toString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime now = LocalDateTime.now();

        StringBuilder sb = new StringBuilder();
        sb.append(businessName).append("\n").append(businessAddress)
            .append("\n").append(client.getContact()).append("\n\n")
            .append("Invoice For Month of: ").append(invoiceDate.getMonth())
            .append(" ").append(invoiceDate.getYear()).append("\n")
            .append("Invoice Date: ").append(dtf.format(now));
        return sb.toString();
    }

}
