package com.home.recurssion_backtracting_level_1;

import java.util.Scanner;

//Can go either vertical, horizontal or diagonal. At on time it can make jump of either one or more steps but within limit.
public class PrintMazePathWithJumps {
    public static final Scanner scan = new Scanner(System.in);

    public static void printMazePathWithJumps() {
        System.out.println("Enter number of rows: ");
        int n = scan.nextInt();
        System.out.println("Enter number of columns: ");
        int m = scan.nextInt();

        displayPaths(1, 1, n, m, "");
    }

    private static void displayPaths(int sr, int sc, int dr, int dc, String pathSoFar) {
        if (sr == dr && sc == dc) {
            System.out.println(pathSoFar);
            return;
        }

        //horizontal moves
        for (int moveSize = 1; moveSize <= dc - sc; moveSize++) {
            displayPaths(sr, sc + moveSize, dr, dc, pathSoFar + "h" + moveSize);
        }

        //vertical moves
        for (int moveSize = 1; moveSize <= dr - sr; moveSize++) {
            displayPaths(sr + moveSize, sc, dr, dc, pathSoFar + "v" + moveSize);
        }

        //diagonal moves
        for (int moveSize = 1; moveSize <= dr - sr && moveSize <= dc - sc; moveSize++) {
            displayPaths(sr + moveSize, sc + moveSize, dr, dc, pathSoFar + "d" + moveSize);
        }
    }

}
