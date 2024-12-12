package assignments.ex1;

import java.util.Arrays;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Converts a given number (as a formatted string) to its decimal integer representation.
     * If the input is not valid, returns -1.
     *
     * @param num a String representing a number in base [2-16].
     * @return the decimal value of the number, or -1 if invalid.
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(isNumber(num)) {
            if (num.matches(".*[0-9].*") && !num.matches(".*[A-Zb].*")) { // return the number in case of decimal
                int dec = Integer.parseInt(num);
                return dec;
            }
            String[] arr = num.split("b");
            String partNumber = arr[0];
            String partBase = arr[1];
            char baseChar = partBase.charAt(0);
            int base = returnNumber(baseChar);
            char[] charArray = partNumber.toCharArray();
            int sum = 0;
            for (int i = 0; i < charArray.length; i++) {
                int numBase = returnNumber(charArray[charArray.length - 1 - i]);
                sum += (int) (numBase * (Math.pow(base, i)));
            }
            return sum;
        }
        else
            return ans;
    }

    /**
     * Maps a character to its numeric value (0-16).
     * For example, 'A' -> 10, 'B' -> 11, ..., 'G' -> 16.
     *
     * @param base a character representing a digit or a base.
     * @return the numeric value of the character, or -1 if invalid.
     */
    public static int returnNumber(char base) {
        char[] charBaseArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int baseNum=0;
        for (int i = 0; i < charBaseArr.length; i++) {
            if (charBaseArr[i] == base) {
                baseNum=i;
                return i;
            }
        }
        return -1; // Return -1 if the character is not a valid base character
    }

    /**
     * Checks if a given string is in a valid number format.
     * Valid numbers have the format "<number><b><base>", e.g., "101b2", "123bG".
     *
     * @param a a String representing a number.
     * @return true if the string is valid, false otherwise.
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }
        // Ensure 'b' is at the second-to-last position
        if (a.charAt(a.length() - 2) != 'b') {
            return false;
        }

        // Check if the string contains only allowed characters
        if (!a.matches("^[A-Gb0-9]+$")) {
            return false;
        }

        if (a.matches(".*[A-Z].*") && !a.matches(".*[0-9b].*")) {
            return false;
        }

        // Check for numbers without 'b' or with invalid base/digits
        if (a.matches(".*[0-9].*") && !a.matches(".*[A-Zb].*")) {
            return true;
        }

        String[] arr = a.split("b");
        if (arr.length != 2 || arr[0].isEmpty() || arr[1].isEmpty()) {
            return false;
        }

        // Validate base and digits
        String numPart = arr[0];
        String basePart = arr[1];
        char baseChar = basePart.charAt(0);
        int base = returnNumber(baseChar);
        if (base > 16 || base < 2) {
            return false;
        }
        for (char c : numPart.toCharArray()) {
            int digitValue = returnNumber(c);
            if (digitValue >= base || digitValue < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a decimal integer to a number in the given base.
     * Returns an empty string if the input base is invalid (<2 or >16).
     *
     * @param num the decimal number to convert.
     * @param base the target base (2-16).
     * @return the number in the given base as a string, or "" for invalid input.
     */
    public static String int2Number(int num, int base) {
        if (base < 2 || base > 16) return "";

        StringBuilder str = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            num /= base;
            str.append(remainder);
        }
        return str.reverse().toString() + "b" + base;
    }

    /**
     * Checks if two numbers (in string format) are equal in value.
     *
     * @param n1 first number string.
     * @param n2 second number string.
     * @return true if the numbers have the same value, false otherwise.
     */
    public static boolean equals(String n1, String n2) {
        int firstNum = number2Int(n1);
        int secondNum = number2Int(n2);
        return firstNum == secondNum;
    }

    /**
     * Prints the larger value between two numbers and their respective operations.
     *
     * @param numOne first number.
     * @param numTwo second number.
     * @param add result of addition.
     * @param multiply result of multiplication.
     * @param oneAdd description of the addition.
     * @param oneMultiply description of the multiplication.
     */
    public static void maxIndex(int numOne, int numTwo, int add, int multiply, String oneAdd, String oneMultiply) {
        if (add >= multiply) {
            System.out.println("max number over[" + numOne + "," + numTwo + "," + oneAdd + "," + oneMultiply + "] is" + oneAdd);
        } else {
            System.out.println("max number over[" + numOne + "," + numTwo + "," + oneAdd + "," + oneMultiply + "] is" + oneMultiply);
        }
    }
}
