package com.home.programs;

import java.util.Scanner;

/*
Input -
9611235

Output -
9
6
1
1
2
3
5
*/

public class PrintNosInDigitStraight {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printNosInDigitStraight() {
        System.out.println("Enter the Digit: ");
        int digit = scanner.nextInt();

        //reverse the number
        int reverseNumber = 0;
        while (digit != 0) {
            int temp1 = digit % 10;
            reverseNumber = reverseNumber * 10 + temp1;
            digit = digit / 10;
        }

        System.out.println("Reverse Number: " + reverseNumber);

        while (reverseNumber != 0) {
            int digitToPrint = reverseNumber % 10;
            reverseNumber = reverseNumber / 10;
            System.out.println(digitToPrint);
        }
    }
}
