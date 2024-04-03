package com.home.dynammic_programming;

import java.util.Scanner;

public class CountBinaryStrings {
    public static final Scanner scan = new Scanner(System.in);

    public static void countBinaryStringsWithNoConsecutiveZeros() {
        System.out.println("Enter string count: ");
        int n = scan.nextInt();

        printCountUsingArrays(n);
        printCountUsingVariables(n);
    }

    //Here we are utilizing the array memory
    private static void printCountUsingArrays(int n) {
        int[] arrZero = new int[n + 1];     //size should be n + 1, because if n is 6 then we need to store count of string with length 6
        int[] arrOne = new int[n + 1];

        //arrZero[0] = 0;     //No need, as default value will be 0. No of string with length 0 will be 0.
        //arrOne[0] = 0;      //No need, as default value will be 0. No of string with length 0 will be 0.

        arrZero[1] = 1;     //No of string with length 1 will be 1.
        arrOne[1] = 1;      //No of string with length 1 will be 1.

        for (int i = 2; i <= n; i++) {
            arrZero[i] = arrOne[i - 1];
            arrOne[i] = arrOne[i - 1] + arrZero[i - 1];
        }

        int finalCount = arrOne[n] + arrZero[n];

        System.out.println("Count: " + finalCount);
    }

    //Here we can just utilize 4 variables
    private static void printCountUsingVariables(int n) {
        int oldZero = 1;    //we can start from n as 1, where string count will also be 1
        int oldOne = 1;     //we can start from n as 1, where string count will also be 1

        for (int i = 2; i <= n; i++) {
            int newZero = oldOne;
            int newOne = oldOne + oldZero;

            oldZero = newZero;
            oldOne = newOne;
        }

        int finalCount = oldZero + oldOne;

        System.out.println("Count: " + finalCount);
    }

}
