package cp510.assignments.assignment2;

import java.math.BigInteger;

/**
 * The Numbers class for UW Java 510
 * 
 * @author Toby Peterson
 *
 */

public class Numbers {

    public static void main(String[] args) {
        System.out.println(factorialBig(20));
    };

    /**
     * Method for determing whether a given number is prime or not
     * 
     * @param num the given integer
     * @return a boolean indicating whether number is prime or not
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    };

    /**
     * Method for determining the least common multiple of two integers
     * 
     * @param param1 an integer
     * @param param2 integer
     * @return an integer that is the least common multiple
     */
    public static int lcm(int param1, int param2) {
        if (param1 == 0 || param2 == 0) {
            return 0;
        }
        ;

        int larger = Math.max(param1, param2);
        int smaller = Math.min(param1, param2);

        int current = larger;
        while (current % smaller != 0) {
            current += larger;
        }
        return current;
    };

    /**
     * A method that determines the great common factor that two given integers
     * have in common
     * 
     * @param param1 an integer
     * @param param2 an integer
     * @return an integer that is the greatest common factor
     */
    public static int gcf(int param1, int param2) {
        if (param1 == 0 || param2 == 0) {
            return 0;
        }
        int greatestCommon = 1;
        for (int i = 1; i <= param1 && i <= param2; i++) {
            if (param1 % i == 0 && param2 % i == 0) {
                greatestCommon = i;
            }
        }
        return greatestCommon;
    };

    /**
     * A method to determine the mean of an array of numbers
     * 
     * @param arr an array of numbers(doubles)
     * @return the mean of the given numbers in the supplied array
     */
    public static double mean(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    };

    /**
     * A method to determine the median number in a given array of numbers
     * 
     * @param arr an array of numbers(double)
     * @return the median number of the array
     */
    public static double median(double[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        if (arr.length % 2 != 0) {
            double middle = (arr.length / 2);
            return arr[(int) middle];
        } else {
            double middleLeft = arr.length / 2 - 0.5;
            double middleRight = arr.length / 2 + 0.5;
            return (arr[(int) middleLeft] + arr[(int) middleRight]) / 2;
        }

        // In case the array needs sorting, guidelines unclear
//      double[] sortableArray = arr;
//      Arrays.sort(sortableArray);
//        if (arr.length % 2 != 0) {
//            double middle = (sortableArray.length / 2);
//            return sortableArray[(int) middle];
//        } else {
//            double middleLeft = sortableArray.length / 2 - 0.5;
//            double middleRight = sortableArray.length / 2 + 0.5;
//            return (sortableArray[(int) middleLeft] + sortableArray[(int) middleRight]) / 2;
//        }
    };

    /**
     * A method to determine the factorial of a number below 20
     *
     * @param num a number below 20
     * @throws illegalArugmentException if the supplied argument is greater than
     *                                  20
     * @return the factorial of the given number
     * 
     */
    public static long factorial(long num) {
        if (num == 0) {
            return 1;
        } else if (num > 20) {
            throw new IllegalArgumentException();
        }
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    };

    /**
     * A method to determine the factorial of a larger number
     * 
     * @param num a number
     * @return the factorial of the supplied number
     */
    public static BigInteger factorialBig(int num) {
        if (num == BigInteger.ZERO || num == BigInteger.ONE) {
            return BigInteger.ONE;
        }
        System.out.println(
        "big int" + num.multiply(factorialBig(num.subtract(BigInteger.ONE))));
        return num.multiply(factorialBig(num.subtract(BigInteger.ONE)));
    };

}