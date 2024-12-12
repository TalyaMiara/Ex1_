package assignments.ex1;
import java.util.Scanner;

import static assignments.ex1.Ex1.number2Int;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc1.next();
            int firstNum=0;
            int secondNum=0;
            if (!num1.equals("quit")) {
                firstNum = Ex1.number2Int(num1);
                if (firstNum != -1) {
                    System.out.println("num1=" + num1 + "is number:true, value:" + firstNum);
                } else {
                    System.out.println("ERR: num1 is in the wrong format!(" + num1 + ")");
                    continue;
                }
            }
        }
        if (num1.equals("quit")){
            System.out.println("quiting now...");
            System.exit(0);
        }
        Scanner sc2=new Scanner(System.in);

    }
}
