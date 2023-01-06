package com.home.programs;

import java.util.Scanner;

/*
* You are required to check if a given set of numbers is a valid pythagorean triplet.
* Check if it is a right angled triangle a^2 + b^2 = h^2
* Take as input three numbers.
* Print true if they can form a phythagorean triplet and false otherwise
*
* Input -
* 5 3 4
*
* Output -
* true
*
* */
public class PhythagoreanTriplets {

    public static final Scanner scanner = new Scanner(System.in);

    public static void printIfPhythagoreanTriplets () {
        System.out.println("Enter number 1: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2: ");
        int number2 = scanner.nextInt();
        System.out.println("Enter number 3: ");
        int number3 = scanner.nextInt();

//        int max = findMax(number1, number2, number3);


    }

    /*private static int findMax(int number1, int number2, int number3) {

        if (number1 > number2) {
            if (number1 > number3) {
                return number1;
            }
        }
    }*/
}
