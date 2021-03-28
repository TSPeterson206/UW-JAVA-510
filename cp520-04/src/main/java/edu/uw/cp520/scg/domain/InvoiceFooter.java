package edu.uw.cp520.scg.domain;

/**
 * The InvoiceFooter class for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceFooter {

    /**
     * The businessName property.
     */
    private String businessName;

    /**
     * The pageNumber property.
     */
    private int pageNumber;

    /**
     * The constructor for the InvoiceFooter class.
     * 
     * @param businessName The business name to be entered into the footer.
     */
    public InvoiceFooter(String businessName) {
        this.businessName = businessName;
        pageNumber = 1;
    }

    /**
     * The incrementPageNumber method for the InvoiceFooter class.
     */
    public void incrementPageNumber() {
        pageNumber++;
    }

    /**
     * The toString method for the InvoiceFooter class.
     * 
     * @return String The human readable output for the testing of the
     *         InvoiceFooter class.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(businessName)
            .append("                                             ")
            .append("Page ").append(pageNumber);
        return sb.toString();
    }
}
