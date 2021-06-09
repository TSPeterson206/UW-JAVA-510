package expeditors.tsp;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The Driver class for the Expeditors Take Home Assignment. This class takes in
 * 10 string arguments. For the sake of simplicity, I loaded these into a
 * two-dimensional array of strings.
 * 
 * @author Toby Peterson.
 *
 */
public class Driver {

    /**
     * The data input into the project. It is represented by the inputStrings
     * property.
     */
    private static String[][] inputStrings = {
            { "Dave", "Smith", "123 main st.", "seattle", "wa", "43" },
            { "Alice", "Smith", "123 Main St.", "Seattle", "WA", "45" },
            { "Bob", "Williams", "234 2nd Ave.", "Tacoma", "WA", "26" },
            { "Carol", "Johnson", "234 2nd Ave", "Seattle", "WA", "67" },
            { "Eve", "Smith", "234 2nd Ave.", "Tacoma", "WA", "25" },
            { "Frank", "Jones", "234 2nd Ave.", "Tacoma", "FL", "23" },
            { "George", "Brown", "345 3rd Blvd., Apt. 200", "Seattle", "WA",
                    "18" },
            { "Helen", "Brown", "345 3rd Blvd. Apt. 200", "Seattle", "WA",
                    "18" },
            { "Ian", "Smith", "123 main st ", "Seattle", "Wa", "18" },
            { "Jane", "Smith", "123 Main St.", "Seattle", "WA", "13" } };

    /**
     * The HashMap/hm property. This is a <String,Integer> hashmap that stores
     * the full address as a key and the number of occupants at said address as
     * the corresponding value.
     */
    private static HashMap<String, Integer> hm;

    /**
     * The logger property used to log warnings in the event of an exception.
     */
    private final static Logger logger = Logger
        .getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * The main method for the Driver class.
     * 
     * @param args The array of arguments passed to the class.
     */
    public static void main(String[] args) {
        standardizeAddresses();
        standardizeCitiesAndStates("WA");
        breakApartByHousehold();
        print();
    }

    public static String[][] getInputStrings() {
        return inputStrings;
    }

    /**
     * The standardizeAddresses method for the Driver class. It loops through
     * the 2D array, splits each street address into an array, and then
     * eliminates excess commas, enforces capital letters in proper names,
     * standardizes St/Ave/Blvd and rejoins each array.
     */
    public static void standardizeAddresses() {
        for (String[] entry : inputStrings) {
            String[] addressArray = entry[2].split(" ");

            // Capitalizing proper names
            for (int i = 0; i < addressArray.length; i++) {
                addressArray[i] = addressArray[i].substring(0, 1).toUpperCase()
                    + addressArray[i].substring(1).toLowerCase().replace(",",
                        "");

                // Enforcing consistency with periods after St/Ave/Blvd
                if (addressArray[i].equals("St")
                    || addressArray[i].equals("Ave")
                    || addressArray[i].equals("Blvd")) {
                    addressArray[i] = addressArray[i] + ".";
                }
                entry[2] = String.join(" ", addressArray);
            }
        }
    }

    /**
     * The standardizeCitiesAndStates method. It loops through the 2D array and
     * enforces capital letters followed by lower case letter on city names. The
     * state of residence is changed to WA, correcting one instance of FL and
     * two instances of lowercase letters being used.
     * 
     * @param state The state to be entered as the residing state. I made an
     *              assumption that "FL" was intended to be "WA".
     */
    public static void standardizeCitiesAndStates(final String state) {
        for (String[] entry : inputStrings) {
            // Capitalizing city names
            entry[3] = entry[3].substring(0, 1).toUpperCase()
                + entry[3].substring(1).toLowerCase();
            // Capitalizing/standardizing state abbreviations
            entry[4] = state;
        }
        ;
    }

    /**
     * The breakApartByHousehold method for the Driver class. It utilizes a
     * hashmap with the address as the key and the occupancy number as the
     * value. Occupants below 18 are omitted from the count. I interpreted the
     * phrase "older than 18" to mean that the individual can be as young as 18
     * years of age and no lower.
     */
    public static void breakApartByHousehold() {
        hm = new HashMap<String, Integer>();

        int counter = 0;
        String address = "";
        for (int i = 0; i < inputStrings.length; i++) {
            address = inputStrings[i][2] + ", " + inputStrings[i][3] + ", "
                + inputStrings[i][4];
            if (hm.containsKey(address)) {
                counter = hm.get(address);
                counter++;
                // Enforcing that occupants not be listed if 17 years of age or
                // younger.
                int ageCheck = Integer.parseInt(inputStrings[i][5]);
                if (ageCheck > 13) {
                    hm.put(address, counter);
                }
            } else {
                hm.put(address, 1);
            }
        }
    }

    /**
     * The print method for the Driver class. This method calls the utility
     * class PrintHelper to perform the formatting logic.
     */
    public static void print() {
        try {
            PrintHelper.printEndProduct(inputStrings, hm);
        } catch (UnsupportedEncodingException e) {
            logger.warning("There was an issue in printing!");
            e.printStackTrace();
        }
    }
}