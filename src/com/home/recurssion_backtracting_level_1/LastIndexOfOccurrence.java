package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class LastIndexOfOccurrence {
    public static final Scanner scan = new Scanner(System.in);

    public static void findLastOcc() {
        System.out.println("Enter number of array elements: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements - ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the number to be searched: ");
        int number = scan.nextInt();

        int index = findLastOccurrencePepSolution(arr, number, 0);
        System.out.println("Index: " + index);
    }

    private static int findLastOccurrenceNonRecursion(int[] arr, int number, int index) {
        int lastIndx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                lastIndx = i;
            }
        }

        return lastIndx;
    }

    public static int lastIndex = -1;


    //Here comparision happening while going up in the stack and using static varaible to store last index
    private static int findLastOccurrenceUsingRecursion(int[] arr, int number, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == number) {
            lastIndex = index;
        }
        findLastOccurrenceUsingRecursion(arr, number, index + 1);
        return lastIndex;
    }

    //First go up till the end of the stack, then while coming down compare
    private static int findLastOccurrencePepSolution(int[] arr, int number, int index) {
        if (index == arr.length) {
            return -1;
        }

        int lastIndex = findLastOccurrenceUsingRecursion(arr, number, index + 1);

        if (lastIndex == -1) {
            if (arr[index] == number) {
                return index;
            }
            else {
                return lastIndex;
            }
        } else {
            return lastIndex;
        }
    }
}
