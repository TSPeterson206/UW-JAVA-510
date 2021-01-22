package edu.uw.cp520.scg.domain;

/**
 * The NonBillableAccount enum for the invoice project. It contains a set of
 * values for non-billable hours.
 * 
 * @author Toby Peterson.
 *
 */
public enum NonBillableAccount implements Account {

    /**
     * The sick leave enum value.
     */
    SICK_LEAVE("Sick Leave"),
    /**
     * The vacation enum value.
     */
    VACATION("Vacation"),
    /**
     * The business development enum value.
     */
    BUSINESS_DEVELOPMENT("Business Development");

    /**
     * The name property for the NonBillableAccount enum.
     */
    private String name;

    private NonBillableAccount(String name) {
        this.name = name;
    };

    /**
     * The getName method for the NonBillableAccount enum.
     * 
     * @return String The name for this account.
     */
    public String getName() {
        return this.name;
    };

    /**
     * The isBillable method for the NonBillableAccount enum.
     * 
     * @return boolean A boolean value indicating whether the account is
     *         billable or not.
     */
    public boolean isBillable() {
        return false;
    };

//    /**
//     * The toString method for the NonBillableAccount enum.
//     * 
//     * @return String The friendly name for the enumerated value.
//     */
//    public String toString() {
//        return this.name;
//    };
}
