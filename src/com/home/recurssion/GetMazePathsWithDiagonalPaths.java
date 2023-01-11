package com.home.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithDiagonalPaths {
    public static final Scanner scan = new Scanner(System.in);

    public static void getMazePathWithDiagonalPaths() {
        System.out.println("Enter number of rows: ");
        int n = scan.nextInt();
        System.out.println("Enter number of columns: ");
        int m = scan.nextInt();

        ArrayList<String> res = getPaths(1, 1, n, m);
        System.out.println(res);
    }

    private static ArrayList<String> getPaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        //horizontal moves
        for (int moveSize = 1; moveSize <= dc - sc; moveSize++) {
            ArrayList<String> hPaths = getPaths(sr, sc + moveSize, dr, dc);
            for (String hPath: hPaths) {
                paths.add("h" + moveSize + hPath);
            }
        }

        //vertical moves
        for (int moveSize = 1; moveSize <= dr - sr; moveSize++) {
            ArrayList<String> vPaths = getPaths(sr + moveSize, sc, dr, dc);
            for (String vPath: vPaths) {
                paths.add("v" + moveSize + vPath);
            }
        }

        //diagonal moves
        for (int moveSize = 1; moveSize <= dr - sr && moveSize <= dc - sc; moveSize++) {
            ArrayList<String> dPaths = getPaths(sr + moveSize, sc + moveSize, dr, dc);
            for (String dPath: dPaths) {
                paths.add("d" + moveSize + dPath);
            }
        }

        return paths;
    }


}
