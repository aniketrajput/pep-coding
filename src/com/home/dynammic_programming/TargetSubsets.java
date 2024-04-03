package com.home.dynammic_programming;

import java.util.Scanner;

public class TargetSubsets {
    public static final Scanner scan = new Scanner(System.in);

    public static void targetSum() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        System.out.println("Enter target sum: ");
        int targetSum = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter n elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        isTargetSum(arr, targetSum);
    }

    private static void isTargetSum(int[] arr, int targetSum) {
        boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i-1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i-1];
                        if (j >= val) {
                            if (dp[i-1][j-val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Is subset possibel for target sum : " + dp[arr.length][targetSum]);
    }
}
