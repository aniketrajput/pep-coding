package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class PrintDecreasing {

    public static final Scanner scanner = new Scanner(System.in);

    public static void printDecreasing() {
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        pd(n);
    }

    public static void pd(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        pd(n-1);
    }
}
