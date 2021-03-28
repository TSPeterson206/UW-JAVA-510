package edu.uw.cp520.scg.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvoiceFooterTest {

    @Test
    void toStringTest() {
        InvoiceFooter footer = new InvoiceFooter("Microsoft");
        assertEquals(
            "Microsoft                                             Page 1",
            footer.toString());
    }

    @Test
    void pageIncrementTest() {
        InvoiceFooter footer = new InvoiceFooter("Microsoft");
        assertEquals(
            "Microsoft                                             Page 1",
            footer.toString());
        footer.incrementPageNumber();
        assertEquals(
            "Microsoft                                             Page 2",
            footer.toString());
    }

}
