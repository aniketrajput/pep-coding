package com.home.recurssion_backtracting_level1;

import java.util.Scanner;

public class PrintStringSubSequence {

    public static final Scanner scan = new Scanner(System.in);

    public static void printSubsequence() {
        System.out.println("Enter String: ");
        String str = scan.next();

        displaySubSequence(str, "");
    }

    //Check book for explanation
    private static void displaySubSequence(String question, String answer) {
        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }

        char ch = question.charAt(0);
        String restOfQuestion = question.substring(1);

        displaySubSequence(restOfQuestion, answer + ch);    //yes call
        displaySubSequence(restOfQuestion, answer + "");    //no call
    }
}
