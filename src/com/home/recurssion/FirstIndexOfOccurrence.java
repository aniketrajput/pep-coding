package com.home.recurssion;

import java.util.Scanner;

public class FirstIndexOfOccurrence {

    public static final Scanner scan = new Scanner(System.in);

    public static void findFirstOcc() {
        System.out.println("Enter number of array elements: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements - ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the number to be searched: ");
        int number = scan.nextInt();

        int index = findFirstOccurrencePepSolutionEfficientWay(arr, number, 0);
        System.out.println("Index: " + index);
    }

    private static int findFirstOccurrenceNonRecursion(int[] arr, int number, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static int firstIndx = -1;

    private static int findFirstOccurrenceUsingRecursion(int[] arr, int number, int index) {
        if (index == arr.length)
            return -1;

        int firstIndx = findFirstOccurrenceUsingRecursion(arr, number, index + 1);

        if (arr[index] == number) {
            firstIndx = index;
        }

        return firstIndx;
    }

    //this will make calls till last and then while coming back down the stack it will compare.
    private static int findFirstOccurrencePepSolution(int[] arr, int number, int index) {
        if (index == arr.length)
            return -1;

        int firstIndx = findFirstOccurrencePepSolution(arr, number, index + 1);

        if (arr[index] == number) {
            return index;
        } else {
            return firstIndx;
        }
    }

    //this will compare while going up the stack and return when found

    private static int findFirstOccurrencePepSolutionEfficientWay(int[] arr, int number, int index) {
        if (index == arr.length)
            return -1;

        if (arr[index] == number) {
            return index;
        }
        else {
            int firstIndx = findFirstOccurrencePepSolutionEfficientWay(arr, number, index + 1);
            return firstIndx;
        }
    }
}
