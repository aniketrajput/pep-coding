package com.home.programs;

import java.util.Scanner;

/*
* You are required to print the Greatest Common Divisor (GCD) of two numbers. (Sab se bada number jo dono ko divide karta hai)
* You are also required to print the Lowest Common Multiple (LCM) of the same numbers. (Sab se chota number jo dono ke table me ata hai, jo dono ka multiple ho)
* */
public class GcdAndLcm {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printGcdAndLcm () {
        System.out.println("Enter Number 1: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter Number 2: ");
        int num2 = scanner.nextInt();
        int tempN1 = num1;
        int tempN2 = num2;

        while(num1 % num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }

        int gcd = num2;         //the last number that is doing division is GCD
        int lcm = (tempN1 * tempN2) / gcd;

        System.out.println("GCD: " + gcd + " LCM: " + lcm);

    }


}
