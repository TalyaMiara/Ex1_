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
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(isNumber(num)){
            if (num.matches(".*[0-9].*")&&!num.matches(".*[A-Z].*")){
                int dec= Integer.parseInt(num);
                return dec;
            }
            String[] arr = num.split("b");
            String numPart = arr[0];
            String basePare = arr[1];
            char theBsaePaer= basePare.charAt(0);
            int numBase= returnNumber(theBsaePaer);
            char[] arrayOfChars=numPart.toCharArray();
            int calculate=0;
            for (int i = 0; i < arrayOfChars.length; i++) {
                int base=returnNumber(arrayOfChars[arrayOfChars.length-1-i]);
                calculate+=(int) (base*(Math.pow(numBase, i)));
            }
            return calculate;
        }
        else return ans;
    }


    public static int returnNumber(char base) {
        char[] charBaseArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int baseNum = 0;
        for (int i = 0; i < charBaseArr.length; i++) {
            if (charBaseArr[i] == base) {
                baseNum = i;
                return i;
            }
        }
        return -1;
    }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber (String a){
            boolean ans = true;
            if(a.isEmpty()||a==null){
                return !ans;
            }
            if (!a.matches("^[A-Gb0-9]+$")){
                return false;
            }
            if (a.matches(".*[0-9].*")&& !a.matches(".*[A-Zb].*")){
                return true;
            }
            if (a.matches(".*[A-Z].*")&& !a.matches(".*[0-9b].*")){
                return false;
            }
            if (a.charAt(a.length()-2)!= 'b'){
                return false;
            }
            String [] arr= a.split("b");
            String numPart= arr[0];
            String basePart= arr[1];
            if (arr.length != 2){
                return false;
            }
            if (numPart.isEmpty()|| basePart.isEmpty()){
                return false;
            }
            if (!basePart.matches(".*[A-G].*")){
                int base= Integer.parseInt(basePart);
                if (base>9){
                    return false;
                }
            }
            char baseChar= basePart.charAt(0);
            int base= returnNumber(baseChar);
            char [] arrOfChars= numPart.toCharArray();
            for (int i = 0; i < arrOfChars.length; i++) {
                int numBase= returnNumber(arrOfChars[arrOfChars.length-1-i]);
                if (base>16|| base<2 ||numBase<0) {
                    return false;
                }
                    if (numBase>= base) {
                        return false;

                    }
                }
            return true;
            }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number ( int num, int base){
            int max=16;
            int min=2;
            String ans = "";
            if (base>max ||base<min){
                return ans;
            }

            int temporary;
            StringBuilder str=new StringBuilder();
            while (num>0){
                temporary= num%base;
                num=num/base;
                str.append(temporary);
            }
            String resTemp= str.toString();
            String reverseString= new StringBuilder(resTemp).reverse().toString();
            ans= reverseString + "b" +base;
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals (String n1, String n2){
            boolean ans = true;
            int firstNum=number2Int(n1);
            int secondNum=number2Int(n2);
            if (firstNum == secondNum){
                return ans;
            }
            else return false;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param add, multiply an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
//        public static int maxIndex (int numOne, int numTwo,){
//            int ans = 0;
//           if ()
//            return ans;
//        }
    }



