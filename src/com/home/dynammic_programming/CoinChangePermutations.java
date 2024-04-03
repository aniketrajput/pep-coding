package com.home.dynammic_programming;

import java.util.Scanner;

public class CoinChangePermutations {
    public static final Scanner scan = new Scanner(System.in);

    public static void coinChangePermutations() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        System.out.println("Enter amount: ");
        int amount = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter n elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        displayNumberOfPermutations(arr, amount);
    }

    private static void displayNumberOfPermutations(int[] arr, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    dp[i] = dp[i] + dp[i - arr[j]];
                }
            }
        }
        System.out.println("Number of possible permutations: " + dp[amount]);
    }
}
