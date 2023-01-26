package com.home.dynammicprogramming;

import java.lang.management.MemoryType;
import java.util.Scanner;

public class ZeroOneKnapsack {
    public static final Scanner scan = new Scanner(System.in);

    public static void zeroOneKnapsack() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter values: ");
        for (int i = 0; i < values.length; i++) {
            values[i] = scan.nextInt();
        }

        System.out.println("Enter weights: ");
        for (int i = 0; i < weights.length; i++) {
            weights[i] = scan.nextInt();
        }

        System.out.println("Enter bag capacity: ");
        int capacity = scan.nextInt();

        displayMaxPossibleValue(weights, values, capacity);
    }

    private static void displayMaxPossibleValue(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i < dp.length; i++) {           //0th row and 0th column are zero, start from dp[1][1]
            for (int j = 1; j < dp[0].length; j++) {

                if (j >= weights[i-1]) {       //if weight is less than/ equal to capacity then only it can be included. Or if capacity is greater than/ equal to weight then only weight will be included
                    int remainingCapacity = j - weights[i - 1];
                    if (dp[i-1][remainingCapacity] + values[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][remainingCapacity] + values[i-1];
                    } else {
                        dp[i][j] = dp[i-1][j];      //when weight is not included
                    }
                } else {
                    dp[i][j] = dp[i-1][j];      //when weight is not included
                }

            }
        }

        System.out.println("Max possible value: " + dp[weights.length][capacity]);
    }
}
