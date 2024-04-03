package com.home.dynammic_programming;

import java.util.Scanner;

//Climbing or going up the stairs. We are going from down to up
public class ClimbingStairsVariableJumps {
    public static final Scanner scan = new Scanner(System.in);

    public static void climbingStairsCount() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter arr elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = getStairsCount(arr, n);

        System.out.println("Answer: " + answer);
    }


    private static int getStairsCount(int[] arr, int n) {
        int[] dp = new int[n + 1];

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {        //Note j should start with 1, because we need ith next element in addition
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }


}
