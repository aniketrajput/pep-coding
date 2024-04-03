package com.home.dynammic_programming;

import java.util.Scanner;

public class CountSubsequnceOfFormAiBjCk {

    public final static Scanner scan = new Scanner(System.in);

    public static void findSubsequnce() {
        System.out.println("Enter the String: ");
        String str = scan.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else if (str.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }
        }

        System.out.println("Number of Subsequence: " + abc);
    }
}
