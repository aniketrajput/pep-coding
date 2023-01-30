package com.home.recurssionbacktracting;

import java.util.Scanner;

public class PrintStairPaths {
    public static final Scanner scan = new Scanner(System.in);

    public static void printStairsPath() {
        System.out.println("Enter number of stairs: ");
        int n = scan.nextInt();

        getPaths(n, "");
    }

    private static void getPaths(int question, String answer) {
        if (question == 0) {
            System.out.println(answer);
            return;
        } else if (question < 0) {
            return;
        }

        getPaths(question - 1, answer + "1");       //answer should be String, if we keep int then addition will happen
        getPaths(question - 2, answer + "2");
        getPaths(question - 3, answer + "3");
    }
}
