package com.home.programs;

public class ZPattern {

    public static void printZPattern() {
        System.out.println("*****");

        int k = 3;
        int j = k;

        for (int i = 0; i < 3; i++) {
            while (j!=0) {
                System.out.print(" ");
                j--;
            }
            System.out.println("*");

            j = --k;
        }
        System.out.println("*****");
    }
}
