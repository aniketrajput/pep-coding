package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class PrintEncoding {
    public static final Scanner scan = new Scanner(System.in);

    public static void printEncoding() {
        System.out.println("Enter String: ");
        String str = scan.next();

        displayEncoding(str, "");
    }

    private static void displayEncoding(String question, String answerSoFar) {
        if (question.length() == 0) {
            System.out.println(answerSoFar);
            return;
        } else if (question.length() == 1) {
            char ch = question.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int encodingIndx = ch - '0';
                char aplha = (char) ('a' + encodingIndx - 1);   //if expected is 'c' then, 'a' + 3 - 1 = 'c'
                System.out.println(answerSoFar + aplha);
            }
        } else {
            char ch1 = question.charAt(0);
            String restOfQuestion1 = question.substring(1);

            if (ch1 == '0') {
                return;
            } else {
                int ch1EncodingIndx = ch1 - '0';
                char aplha = (char) ('a' + ch1EncodingIndx - 1);   //if expected is 'c' then, 'a' + 3 - 1 = 'c'
                displayEncoding(restOfQuestion1, answerSoFar + aplha);
            }

            String ch2 = question.substring(0, 2);
            String restOfQuestion2 = question.substring(2);

            int ch2EncodingIndx = Integer.parseInt(ch2);
            if (ch2EncodingIndx < 26) {
                char aplha = (char) ('a' + ch2EncodingIndx - 1);
                displayEncoding(restOfQuestion2, answerSoFar + aplha);
            }
        }
    }
}
