package com.home.dynammicprogramming;

import java.util.Scanner;

public class ClimbingStairsWithMinimumMoves {
    public static final Scanner scan = new Scanner(System.in);

    public static void findMimMoves() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter n elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int minMoves = getMinMoves(arr, n);
        System.out.println("Minimum Moves: " + minMoves);
    }

    private static int getMinMoves(int[] arr, int n) {
        Integer[] dp = new Integer[n + 1];  //We created Integer[] because default value will be null and null will represent that there are no paths.

        dp[n] = 0;  //n -> n 0 moves but 1 path

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {                   //if arr[i] has 0, then no steps or jump can be taken from there and dp[i] should remain null
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i+j] != null) {                        //if dp[i+j] is null then Math.min() won't work below
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
