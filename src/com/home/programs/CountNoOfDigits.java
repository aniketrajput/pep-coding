package com.home.programs;

import java.util.Scanner;

public class CountNoOfDigits {
    private static final Scanner scanner = new Scanner(System.in);

    public static void findNoOfDigits() {
        System.out.println("Enter the Digit: ");
        int digit = scanner.nextInt();
        int count = 0;

        while (digit != 0) {
            digit = digit / 10;
            count++;
        }

        System.out.println("Count : " + count);
    }

}
