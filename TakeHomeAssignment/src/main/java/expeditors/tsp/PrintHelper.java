package expeditors.tsp;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The PrintHelper class for the expeditors take home project. It is utilized to
 * 
 * @author toby
 *
 */
public class PrintHelper {

    private static List<String> listOfOccupants = new ArrayList<String>();
    private static List<String> omitted = new ArrayList<String>();

    /**
     * The produceEndProduct method for the PrintHelper class.
     * 
     * @param array The 2D array of input strings, now groomed a bit more than
     *              on initial input.
     * @param hm    The hashmap containing the address as keys and the occupancy
     *              as values.
     * @return String The completed string to return.
     * @throws UnsupportedEncodingException The exception thrown when all hope
     *                                      is lost or when there is an encoding
     *                                      exception.
     */
    public static String printEndProduct(String[][] array,
        HashMap<String, Integer> hm) throws UnsupportedEncodingException {

        final StringBuilder sb = new StringBuilder();
        final Formatter fm = new Formatter(sb, Locale.US);
        String item;
        int ageCheck;

        fm.format("%n%s %n%s %n%s%n",
            "==================================================================================================",
            "=============================== Expeditors Take Home Assignment ==================================",
            "==================================================================================================");

        for (Map.Entry<String, Integer> mapElement : hm.entrySet()) {
            final String key = (String) mapElement.getKey();
            final int value = ((int) mapElement.getValue());

            fm.format("%n%s %2s%n", "Household Address: ", key)
                .format("%s %2s%n", "Occupancy At Address: ", value).format(
                    "%-28s%n", "---------------------------------------------");

            for (int i = 0; i < array.length; i++) {
                item = array[i][2] + ", " + array[i][3] + ", " + array[i][4];
                if (item.equals(mapElement.getKey())) {
                    ageCheck = Integer.parseInt(array[i][5]);
                    if (ageCheck > 13) {
                        listOfOccupants.add(String.join(", ", array[i]));
                    } else {
                        omitted.add(String.join(", ", array[i]));
                    }
                }
            }

            if (listOfOccupants.size() > 1
                && (!listOfOccupants.get(0).split(",")[1]
                    .equals(listOfOccupants.get(1).split(",")[1]))) {
                listOfOccupants = sort(listOfOccupants, "different");
                fm.format("%s%n%n", String.join("\n", listOfOccupants));
            } else {
                listOfOccupants = sort(listOfOccupants, "same");
                fm.format("%s%n%n", String.join("\n", listOfOccupants));

            }
            listOfOccupants.clear();
        }

        fm.format("%n%s %n%s %n%s%n", "Omitted",
            "---------------------------------------------",
            String.join("", String.join("\n", omitted)));

        fm.format("%n%s %n%s %n%s%n",
            "==================================================================================================",
            "============================================ End =================================================",
            "==================================================================================================");

        String output = fm.toString();
        fm.close();
        System.out.println(output);
        return output;

    }

    /**
     * The sort method for the PrintHelper class. It takes in an array of
     * strings and a second argument to guide it to sort via ascending or
     * descending order.
     * 
     * @param list The list of strings to be sorted.
     * @param str  The string indicating if the list contains different last
     *             names or not.
     * @return The sorted list of strings.
     */
    public static List<String> sort(List<String> list, String str) {
        List<String> sortedNames = list.stream().sorted()
            .collect(Collectors.toList());

        Collections.sort(sortedNames, new Comparator<String>() {
            public int compare(String one, String two) {
                if (str.equals("different")) {
                    return (two.compareTo(one));
                } else {
                    return (one.compareTo(two));
                }
            }
        });
        return sortedNames;
    }
}
