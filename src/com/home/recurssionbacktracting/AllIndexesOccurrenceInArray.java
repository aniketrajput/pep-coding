package com.home.recurssionbacktracting;

import java.util.Scanner;

public class AllIndexesOccurrenceInArray {
    public static final Scanner scan = new Scanner(System.in);

    public static void findAllOcc() {
        System.out.println("Enter number of array elements: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements - ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the number to be searched: ");
        int number = scan.nextInt();

        int[] indexes = findAllIndexes(arr, number, 0, 0);
        for (int i = 0; i < indexes.length; i++) {
            System.out.println("Index: " + indexes[i]);
        }

    }

    private static int[] findAllIndexes(int[] arr, int number, int index, int count) {
        if (index == arr.length) {
            return new int[count];
        }

        int[] iArr;
        if (arr[index] == number) {
            iArr = findAllIndexes(arr, number, index + 1, count + 1);
            iArr[count] = index;
        } else {
            iArr = findAllIndexes(arr, number, index + 1, count);
        }
        return iArr;
    }

}
