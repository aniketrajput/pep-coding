package com.home.dynammic_programming;

import java.util.Scanner;

public class Fibonacci {
    public static final Scanner scan = new Scanner(System.in);

    public static void findFibonacci() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();

        int fib = getFibonacciUsingRecursion(n);

        int[] questionBank = new int[n + 1];    //Size should be n + 1
        int fibMomoized = getFibMemoized(n, questionBank);

        System.out.println("Fib using recursion: " + fib);
        System.out.println("Fib using memoized: " + fibMomoized);
    }

    private static int getFibMemoized(int n, int[] questionBank) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (questionBank[n] != 0) {
            return questionBank[n];
        }

        int fibnm1 = getFibonacciUsingRecursion(n - 1);
        int fibnm2 = getFibonacciUsingRecursion(n - 2);
        int fibn = fibnm1 + fibnm2;

        questionBank[n] = fibn;

        return fibn;

    }

    private static int getFibonacciUsingRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fibnm1 = getFibonacciUsingRecursion(n - 1);
        int fibnm2 = getFibonacciUsingRecursion(n - 2);
        int fibn = fibnm1 + fibnm2;

        return fibn;
    }


}
