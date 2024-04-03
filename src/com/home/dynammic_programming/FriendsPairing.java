package com.home.dynammic_programming;

import java.util.Scanner;

public class FriendsPairing {
    public static final Scanner scan = new Scanner(System.in);

    public static void printFriendsPairingWays() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * (i-1);
        }

        System.out.println("Ways: " + dp[n]);
    }

}
