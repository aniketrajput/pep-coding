package com.home.recurssionbacktracting;

import java.util.Scanner;

public class PrintKeypadCombination {
    public static final Scanner scan = new Scanner(System.in);

    public static void keypadCombination() {
        System.out.println("Enter String: ");
        String str = scan.next();

        printKeyPadCombination(str, "");
    }

    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static void printKeyPadCombination(String question, String answer) {
        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }

        char ch = question.charAt(0);
        String restOfString = question.substring(1);

        String codeForCh = codes[ch - '0']; //suppose ch is '7' then it is in char form to get it in numeric form we will have to subtract it by 48 or '0'

        for (int i = 0; i < codeForCh.length(); i++) {
            char chCode = codeForCh.charAt(i);
            printKeyPadCombination(restOfString, answer + chCode);
        }
    }

}
