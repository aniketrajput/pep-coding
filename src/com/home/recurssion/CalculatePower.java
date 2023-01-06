package com.home.recurssion;

/*
* Calculate power(x, n) using Recursion
*
* */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class CalculatePower {
    private static final Scanner scanner = new Scanner(System.in);

    public static void calculatePower() {
        System.out.println("Enter x: ");
        int x = scanner.nextInt();
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        int result = power(x, n);
        System.out.println("Result: " + result);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int temp = power(x, n - 1);
        int result = x * temp;
        return result;
    }

}
