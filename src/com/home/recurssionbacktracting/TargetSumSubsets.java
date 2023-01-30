package com.home.recurssionbacktracting;

import java.util.Scanner;

public class TargetSumSubsets {
    public static final Scanner scan = new Scanner(System.in);

    public static void printTargetSumSubsets() {
        System.out.println("Enter number of elements: ");
        int n = scan.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter target subset: ");
        int targetSubset = scan.nextInt();

        displayTargetSubsets(arr, 0, targetSubset, "", 0);
    }

    private static void displayTargetSubsets(int[] arr, int index, int targetSubset, String subsetSoFar, int sum) {
        if (index == arr.length) {
            if (sum == targetSubset) {
                System.out.println(subsetSoFar);
            }
            return;
        }

        displayTargetSubsets(arr, index + 1, targetSubset, subsetSoFar + arr[index] + ", ", sum + arr[index]);
        displayTargetSubsets(arr, index + 1, targetSubset, subsetSoFar, sum);
    }
}
