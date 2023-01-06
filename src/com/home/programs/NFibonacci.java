package com.home.programs;

import java.util.Scanner;

public class NFibonacci {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printNFibonacci() {
        int n = scanner.nextInt();

        int a = 0;
        int b = 1;
        int c = 0;

        System.out.print(a + " ");
        System.out.print(b + " ");

        for (int i = 0; i < n - 2; i++) {
            c = a +b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
