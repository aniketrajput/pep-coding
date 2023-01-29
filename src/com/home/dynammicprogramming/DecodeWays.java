package com.home.dynammicprogramming;

import java.util.Scanner;

public class DecodeWays {
    public final static Scanner scan = new Scanner(System.in);

    public static void findDecodeWays() {
        System.out.println("Enter the String: ");
        String str = scan.next();

        printDecodeWays(str);
    }

    private static void printDecodeWays(String str) {
        int[] dp = new int[str.length()];

        dp[0] = 1;          //the first char can never be 0, so there will always be 1 way

        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = 0;
                }
            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        System.out.println("Number of ways: " + dp[str.length() - 1]);
    }

}
