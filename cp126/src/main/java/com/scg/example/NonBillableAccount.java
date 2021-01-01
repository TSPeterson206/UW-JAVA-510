package com.scg.example;

public enum NonBillableAccount
//extends Enum<NonBillableAccount>
    implements Account {

    SICK_LEAVE, VACATION, BUSINESS_DEVELOPMENT;

    public String getName() {
    };

//    Getter for the name of this account.
    public boolean isBillable() {
    };

//    Determines if this account is billable.
    public String toString() {
    };

//    Returns the friendly name for this enumerated value.
}
