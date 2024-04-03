package com.home.dynammic_programming;

import java.util.Scanner;

public class UnboundedKnapscak {
    public static final Scanner scan = new Scanner(System.in);

    public static void unboundedKnapsack() {
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
        int[] dp = new int[capacity + 1];
        dp[0] = 0;

        System.out.println("capcity: " + capacity);
        System.out.println("dp.length: " + dp.length);

        for (int i = 1; i <= capacity; i++) {
            int max = 0;

            for (int j = 0; j < weights.length; j++) {

                if (weights[j] <= i) {
                    int remainingWeight =  i - weights[j];
                    int remainingValue = dp[remainingWeight];
                    int totalValue = remainingValue + values[j];

                    if (totalValue > max) {
                        max = totalValue;
                    }
                }

            }
            dp[i] = max;
        }

        System.out.println("Max possible value: " + dp[capacity]);
    }
}
