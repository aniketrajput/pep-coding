package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;


//Expectation -> index se end tak sab print kar de
//Faith -> index + 1 se end tak print karna janta hai

public class PrintArray {

    public static final Scanner scan = new Scanner(System.in);

    public static void printArray() {
        System.out.println("Enter number of array elements: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements - ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

//        displayArr(arr, 0);
        displayArrReverse(arr, 0);
    }

    private static void displayArrReverse(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        displayArrReverse(arr, index + 1);
        System.out.println(arr[index]);
    }

    private static void displayArr(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index]);
        displayArr(arr, index + 1);
    }
}
