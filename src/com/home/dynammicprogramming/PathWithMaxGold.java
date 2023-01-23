package com.home.dynammicprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class PathWithMaxGold {
    public static final Scanner scan = new Scanner(System.in);

    public static void goldmine() {
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

        displayMaxGold(arr, n, m);
    }

    //Handle -
    //last column
    //first row
    //last row
    //rest of the cells

    private static void displayMaxGold(int[][] arr, int n, int m) {
        int[][] dp = new int[n][m];

        for (int j = dp[0].length - 1; j >= 0; j--) {       //Columns
            for (int i = dp.length - 1; i >= 0; i--) {      //Rows

                if (j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1]) + arr[i][j];
                } else {
                    /*ArrayList<Integer> elements = new ArrayList<>();      //can find max this way as well
                    elements.add(dp[i][j+1]);
                    elements.add(dp[i+1][j+1]);
                    elements.add(dp[i-1][j+1]);

                    dp[i][j] = Collections.max(elements) + arr[i][j];*/

                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]))+ arr[i][j];
                }
            }
        }

        /*ArrayList firstColElements = new ArrayList<>();       //can do this way as well
        for (int i = 0; i < dp.length; i++) {
            firstColElements.add(dp[i][0]);
        }
        System.out.println("Max Gold: " + Collections.max(firstColElements));
        */

        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        System.out.println("Max Gold: " + max);
    }
}


/*
Input -
n - 6
m - 6
0
1
4
2
8
2
4
3
6
5
0
4
1
2
4
1
4
6
2
0
7
3
2
2
3
1
5
9
2
4
2
7
0
8
5
1

Expected output - 33
* */