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
//            char[] arrOfChars= a.toCharArray();
//            for (int i = 0; i < arrOfChars.length; i++) {
//                if (arrOfChars[i]==' ') {
//                    return !ans;
//                }
//            }
            if (a.contains(" ")){
                return !ans;
            }
            return ans;
        }

    public static boolean isNumber2 (String [] b){
        boolean ans = true;
        if (b.length !=2){
            return  !ans;
        }
        String num=b[0];
        String base=b[1];
        if (num.isEmpty()){
        return !ans;
        }
        if(!base.matches(".*[a-zA-Z].*")){
            int convertedBase= Integer.parseInt(base);
            if(convertedBase>9) {
                return !ans;
        }
        }
        return ans;
    }

    public static boolean isNumber3 (int base, int num){
            boolean answer=true;
            if (base<2 || base>16 || num<0){
                return  false;
            }
            if (num>=base){
                return false;
            }
            return answer;
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
            String ans = "";
            int max=16;
            int min=2;
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
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex (String[]arr){
            int ans = 0;
           if ()
            return ans;
        }
    }



