package com.home.dynammic_programming;

import java.util.Scanner;

public class MinimumCostPath {
    public static final Scanner scan = new Scanner(System.in);

    public static void findMinimumCostPath() {
        System.out.println("Enter n: ");
        int n = scan.nextInt();
        System.out.println("Enter m: ");
        int m = scan.nextInt();
        int[][] arr = new int[n][m];

        System.out.println("Enter n*m elements: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        getMinimumCostPath(arr, n, m);
    }

    //Treat last cell differently
    //Treat last row differently
    //Treat last column differently
    //Rest of cells differently

    private static void getMinimumCostPath(int[][] arr, int n, int m) {
        int[][] dp = new int[n][m];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                if (i == dp.length - 1 && j == dp[0].length - 1) {      //last cell
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {                        //last row
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {                     //last column
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {                                                //rest of cells
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + arr[i][j];
                }

            }
        }

        System.out.println("Minimum Cost: " + dp[0][0]);
    }
}
