package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class PrintPermutations {
    public static final Scanner scan = new Scanner(System.in);

    public static void printPermutations() {
        System.out.println("Enter String: ");
        String str = scan.next();

        displayPermutations(str, "");
    }

    //Check book for explanation
    private static void displayPermutations(String question, String answerSoFar) {
        if (question.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }

        for (int i = 0; i < question.length(); i++) {
            char ch = question.charAt(i);
            String questionLeftPart = question.substring(0, i);
            String questionRightPart = question.substring(i + 1);
            String restOfQuestion = questionLeftPart + questionRightPart;

            displayPermutations(restOfQuestion, answerSoFar + ch);
        }
    }
}
