package com.home.dynammic_programming;

import java.util.Scanner;

public class ArrangeBuildings {
    public static final Scanner scan = new Scanner(System.in);

    public static void arrangeBuildingAndSpacesWithNoConsecutiveBs() {
        System.out.println("Enter string count: ");
        int n = scan.nextInt();

        printCountUsingVariables(n);
    }

    //Here we can just utilize 4 variables
    private static void printCountUsingVariables(int n) {
        int oldBuilding = 1;    //we can start from n as 1, where string count will also be 1
        int oldSpace = 1;     //we can start from n as 1, where string count will also be 1

        for (int i = 2; i <= n; i++) {
            int newBuilding = oldSpace;
            int newSpace = oldSpace + oldBuilding;

            oldBuilding = newBuilding;
            oldSpace = newSpace;
        }

        int oneSideCount = oldBuilding + oldSpace;
        int totalCount = oneSideCount * oneSideCount;

        System.out.println("Count: " + totalCount);
    }
}
