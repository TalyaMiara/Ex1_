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
        int firstNum=0;
        int secondNum=0;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc1.next();
            if (!num1.equals("quit")) {
                firstNum = Ex1.number2Int(num1);
                if (firstNum != -1) {
                    System.out.println("num1=" + num1 + "is number:true, value:" + firstNum);
                } else {
                    System.out.println("ERR: num1 is in the wrong format!(" + num1 + ")");
                    continue;
                }
            }
            if (num1.equals("quit")){
                System.out.println("quiting now...");
                System.exit(0);
            }
            Scanner sc2=new Scanner(System.in);
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num2= sc2.next();
            if (!num2.equals("quit")){
                secondNum=Ex1.number2Int(num2);
                if (firstNum != -1) {
                    System.out.println("num2=" + num2 + "is number:true, value:" + secondNum);
                } else {
                    System.out.println("ERR: num2 is in the wrong format!(" + num2 + ")");
                    continue;
                }
            }
            if (num2.equals("quit")){
                System.out.println("quiting now...");
                System.exit(0);
            }
            Scanner sc3=new Scanner(System.in);
            System.out.println("Enter a base for output: (a number [2,16]");
            int theBaseNumber= sc3.nextInt();
            int addingNum= firstNum+secondNum;
            int multNum= firstNum*secondNum;
            String oneAdd;
            String oneMult;
            oneAdd= Ex1.int2Number(addingNum,multNum);

        }

    }
}
