package com.home.programs;


import java.util.Scanner;

/*
* You are required to display the prime factorization of a number
*
* Input -
* 1440
*
* Output -
* 2 2 2 2 2 3 3 5
*
* */
public class PrimeFactorization {

    private static final Scanner scanner = new Scanner(System.in);

    /*public static void printPrimeFactorization () {
        System.out.println("Enter Number: ");
        int num = scanner.nextInt();

        for (int divisor = 2; divisor <= num; divisor++) {  // we can add condition as divisor * divisor <= n. Because divisor for a number can never be greater than square root of that number. Suppose number is 23, then square root of 23 is 4.795 so not need to go beyond 4.

            while (num % divisor == 0) {
                if (checkIfPrime(divisor)) {    //no need to check this, because divisor is always going to be prime.. divisor will never be 4 because we have already divided by 2, it can never be 6 because we have already divided by 3,etc.
                    System.out.println(divisor);
                }
                num = num / divisor;
            }
        }
    }

    private static boolean checkIfPrime(int i) {
        boolean isPrime = true;

        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }*/


    //Check comments in above code

    public static void printPrimeFactorization () {
        System.out.println("Enter Number: ");
        int num = scanner.nextInt();

        for (int divisor = 2; divisor * divisor <= num; divisor++) {  // we can add condition as divisor * divisor <= n. Because divisor for a number can never be greater than square root of that number. Suppose number is 23, then square root of 23 is 4.795 so not need to go beyond 4.

            while (num % divisor == 0) {
                num = num / divisor;
                System.out.print(divisor + " ");
            }
        }

        if (num != 1) {                 //if in the end if number is not 1 then that remaining number itself is prime. Consider number 46.
            System.out.println(num);
        }

    }

}




















