package com.home.dynammic_programming;

import java.util.Scanner;

public class PaintHouseMultipleColors {
    public static final Scanner scan = new Scanner(System.in);

    public static void paintHouseMultipleColors() {
        System.out.println("Enter number of houses: ");
        int n = scan.nextInt();

        System.out.println("Enter number of colors: ");
        int nColors = scan.nextInt();

        int arr[][] = new int[n][nColors];

        System.out.println("Enter cost: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        findMinCost(arr);

        findMinCostOptimized(arr);
    }

    //This will take n^3 time.
    private static void findMinCost(int[][] arr) {
        int dp[][] = new int[arr.length][arr[0].length];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < dp[0].length; k++) {
                    if (k != j) {
                        if (dp[i - 1][k] < min) {
                            min = dp[i - 1][k];
                        }
                    }
                }

                dp[i][j] = arr[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < dp[0].length; k++) {
            if (dp[arr.length - 1][k] < min) {
                min = dp[arr.length - 1][k];
            }
        }

        System.out.println("Minimum Cost: " + min);
    }


    private static void findMinCostOptimized(int[][] arr) {
        int dp[][] = new int[arr.length][arr[0].length];

        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = arr[0][i];

            if (dp[0][i] < least) {
                secondLeast = least;
                least = dp[0][i];
            } else if (dp[0][i] < secondLeast){
                secondLeast = dp[0][i];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i - 1][j] == least) {
                    dp[i][j] = arr[i][j] + secondLeast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }

                if (dp[i][j] < newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                } else if (dp[i][j] < newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }

            least = newLeast;
            secondLeast = newSecondLeast;
        }

        System.out.println("Minimum Cost: " + least);
    }
}
