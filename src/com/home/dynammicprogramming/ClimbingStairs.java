package com.home.dynammicprogramming;

import java.util.Scanner;

public class ClimbingStairs {
    public static final Scanner scan = new Scanner(System.in);

    public static void climbingStairsCount() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();
        int count1 = countWaysRecursion(n);
        int count2 = countWaysMemoization(n, new int[n + 1]);   //size should be n + 1. Because consider n as 4, then cp for n = 4 will be stored in 4th index and not 3
        int count3 = countWaysTabulation(n);
        System.out.println("Count Recursion: " + count1);
        System.out.println("Count Memoization: " + count2);
        System.out.println("Count Tabulation: " + count3);
    }

    private static int countWaysRecursion(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        int nm1 = countWaysRecursion(n - 1);
        int nm2 = countWaysRecursion(n - 2);
        int nm3 = countWaysRecursion(n - 3);
        int cp = nm1 + nm2 + nm3;

        return cp;
    }

    private static int countWaysMemoization(int n, int[] questionBank) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (questionBank[n] > 0) {
            return questionBank[n];
        }

        //size of questionBank is n + 1 because - lets consider n as 4, then below 3 calls will be executed 4 times, each for 4, 3, 2, and 1 and we need to maintain cp for each n.
        int nm1 = countWaysMemoization(n - 1, new int[n]);
        int nm2 = countWaysMemoization(n - 2, new int[n]);
        int nm3 = countWaysMemoization(n - 3, new int[n]);
        int cp = nm1 + nm2 + nm3;
        questionBank[n] = cp;       //memoization

        return cp;
    }

    private static int countWaysTabulation(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;  //0 -> 0 is only one way

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];  //need to handle for i or else can go index out of bound
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];  //need to handle for i or else can go index out of bound
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }
}
