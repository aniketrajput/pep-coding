package com.home.dynammicprogramming;

import java.util.Scanner;

public class MaxSumSubsequenceNoAdjacents {
    public static final Scanner scan = new Scanner(System.in);

    public static void findMaxSumSubsequence() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        displayMaxSum(arr);
    }

    private static void displayMaxSum(int[] arr) {
        int oldInclude = arr[0];
        int oldExclude = 0;

        for (int i = 1; i < arr.length; i++) {
            int newInclude = oldExclude + arr[i];
            int newExclude = Math.max(oldInclude, oldExclude);

            oldInclude = newInclude;
            oldExclude = newExclude;
        }

        int maxSum = Math.max(oldInclude, oldExclude);

        System.out.println("Max sum: " + maxSum);
    }

}
