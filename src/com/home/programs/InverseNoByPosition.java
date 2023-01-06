package com.home.programs;

import java.util.Scanner;

public class InverseNoByPosition {
    private static final Scanner scanner = new Scanner(System.in);

    public static void alternativeBetterSolutionInverse() {
        System.out.println("Enter the Digit: ");
        int digit = scanner.nextInt();
        int originalPos = 1;
        int inverseRes = 0;

        while(digit != 0) {
            int originalNo = digit % 10;
            int inverseNo = originalPos;
            int inversePos = originalNo;

            inverseRes = (int) (inverseRes + inverseNo * Math.pow(10, inversePos - 1));

            digit = digit / 10;
            originalPos++;
        }

        System.out.println("Inverse Number: " + inverseRes);
    }

    public static void inverseByPosition () {
        System.out.println("Enter the Digit: ");
        int digit = scanner.nextInt();
        int count = 0;
        int tempDigit = digit;

        while (tempDigit != 0) {
            tempDigit = tempDigit / 10;
            count++;
        }

        System.out.println("Count: " + count);

        tempDigit = digit;

        int[] digitArr = new int[count];
        int i = 0;

        while (tempDigit != 0) {
            int modNo = tempDigit % 10;
            digitArr[i] = modNo;
            i++;
            tempDigit = tempDigit / 10;
        }

        System.out.println("digitArr Array Data: ");
        for (int j = 0; j < digitArr.length; j++) {
            System.out.println(digitArr[j]);
        }

        int[] newDigitArr = new int[count];

        for (int j = 0; j < digitArr.length; j++) {
            newDigitArr[count - digitArr[j]] = j + 1;
        }

        System.out.println("newDigitArr Array Data: ");
        for (int j = 0; j < newDigitArr.length; j++) {
            System.out.println(newDigitArr[j]);
        }

        int newNo = 0;

        for (int j = 0; j < newDigitArr.length; j++) {
            newNo = newNo * 10 + newDigitArr[j];
        }

        System.out.println("Result : " + newNo);
    }

}
