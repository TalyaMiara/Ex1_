Ex1- Calculator converts numbers according to different bases
This project is a Java-based solution for a number format converter and calculator.
The program supports number formats in various bases (binary to hexadecimal)
and provides functionalities to convert, calculate, and compare numbers
represented as strings. The primary focus is on working with numbers in bases
ranging from 2 to 16, using letters A to G to represent digits above 9.
The functuons:
1. number2Int(String num)
Converts a given number (in string format) to its decimal integer representation.
Input: A string representing a number in base [2-16].
Output: The decimal value of the number, or -1 if the input is invalid.
2. returnNumber(char base)
Maps a character to its numeric value (0-16).
Input: A character representing a digit or base.
Output: The numeric value of the character, or -1 if invalid.
3. isNumber(String a)
Checks if a given string is in a valid number format.
Input: A string representing a number.
Output: true if the string is valid, false otherwise.
4. int2Number(int num, int base)
Converts a decimal integer to a number in a specific base.
Input: A decimal number and a base [2-16].
Output: The number in the given base as a string, or an empty string for invalid bases.
5. equals(String n1, String n2)
Checks if two numbers (in string format) are equal in value.
Input: Two strings representing numbers.
Output: true if the numbers are equal, false otherwise.
6. maxIndex(int numOne, int numTwo, int add, int multiply, String oneAdd, String oneMultiply)
Prints the larger result between two arithmetic operations.
Input: Two numbers, their addition and multiplication results, and descriptions of the operations.
