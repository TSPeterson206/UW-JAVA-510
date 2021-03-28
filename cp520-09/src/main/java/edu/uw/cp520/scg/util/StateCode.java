package edu.uw.cp520.scg.util;

/**
 * The StateCode enum for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public enum StateCode {

    /**
     * The CA property for the StateCode enum.
     */
    CA("CA"),
    /**
     * The WA property for the StateCode enum.
     */
    WA("WA");

    /**
     * The friendlyName property.
     */
    private String friendlyName;

    /**
     * The constructor for the StateCode enum.
     * 
     * @param friendlyName
     */
    private StateCode(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * The forName method for the StateCode enum. Looks up a StateCode by the
     * state name.
     * 
     * @param stateName The state name string passed in.
     * @return StateCode The enum value that is synonymous with the passed in
     *         string.
     */
    public StateCode forName(String stateName) {
        switch (stateName) {
        case "California":
            return StateCode.CA;
        case "Washington":
            return StateCode.WA;

        default:
            return StateCode.CA;
        }
    }

    /**
     * The toString method for the StateCode enum.
     * 
     * @return String The human readable string for the StateCode enum.
     */
    public String toString() {
        return friendlyName;
    }

}
