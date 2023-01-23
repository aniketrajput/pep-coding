package com.home.dynammicprogramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static final Scanner scan = new Scanner(System.in);

    public static void coinChangeCombination() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        System.out.println("Enter amount: ");
        int amount = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter n elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        displayNumberOfCombinations(arr, amount);
    }

    private static void displayNumberOfCombinations(int[] arr, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }

        System.out.println("Number of combinations to pay the amount: " + dp[amount]);
    }
}
