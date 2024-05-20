package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

public class PrintMazePaths {
    public static final Scanner scan = new Scanner(System.in);

    public static void printMazePath() {
        System.out.println("Enter number of rows: ");
        int n = scan.nextInt();
        System.out.println("Enter number of columns: ");
        int m = scan.nextInt();

        displayMazePaths(1, 1, n, m, "");
    }

    //sr - source row
    //sc - source column
    //dr - destination row
    //dc - destination column

    private static void displayMazePaths(int sr, int sc, int dr, int dc, String pathSoFar) {
        if (sr > dr || sc > dc) {
            return;
        }

        if (sr == dr && sc == dc) {
            System.out.println(pathSoFar);
            return;
        }

        //Stupid calls but smart base case
        displayMazePaths(sr, sc + 1, dr, dc, pathSoFar + "h");
        displayMazePaths(sr + 1, sc, dr, dc, pathSoFar + "v");
    }
}
