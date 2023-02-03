package com.home.dynammicprogramming;

import java.util.Scanner;

public class PaintFence {
    public static final Scanner scan = new Scanner(System.in);

    public static void paintFence() {
        System.out.println("Enter number of fences: ");
        int n = scan.nextInt();

        System.out.println("Enter number of colors: ");
        int k = scan.nextInt();

        findNumberOfWays(n, k);
    }

    private static void findNumberOfWays(int n, int k) {
        int sameLastTwo = k * 1;
        int diffLasTwo = k * (k - 1);
        int total = sameLastTwo + diffLasTwo;

        for (int i = 3; i <= n; i++) {
            sameLastTwo = diffLasTwo * 1;
            diffLasTwo = total * (k - 1);
            total = sameLastTwo + diffLasTwo;
        }

        System.out.println("Total ways: " + total);
    }
}
