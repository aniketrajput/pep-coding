package com.home.recurssionbacktracting;

import java.util.Scanner;

public class MaxInArray {
    public static final Scanner scan = new Scanner(System.in);

    public static void findMaxInArray() {
        System.out.println("Enter number of array elements: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements - ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int max = findMaxInArr(arr, 0);
        System.out.println("Max - " + max);
    }

    private static int max = 0;

    private static int findMaxInArr(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        if (arr[index] > max) {
            max = arr[index];
        }
        findMaxInArr(arr, index + 1);

        return  max;
    }

    private static int pepMaxSolution(int[] arr, int index) {
        if (index == arr.length) {
            return arr[index];
        }

        int misa = pepMaxSolution(arr, index + 1);

        if (misa > arr[index]) {
            return misa;
        } else {
            return arr[index];
        }
    }
}
