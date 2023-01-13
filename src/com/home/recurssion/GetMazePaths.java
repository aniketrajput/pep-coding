package com.home.recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {

    public static final Scanner scan = new Scanner(System.in);

    public static void getMazePath() {
        System.out.println("Enter number of rows: ");
        int n = scan.nextInt();
        System.out.println("Enter number of columns: ");
        int m = scan.nextInt();

        ArrayList<String> res = getPaths(1, 1, n, m);
        System.out.println(res);
    }

    //sr - source row
    //sc - source column
    //dr - destination row
    //dc - destination column

    //Expectation -> getPaths[1, 1, 3, 3] - will return all paths

    //Faith -> getPaths[1, 2, 3, 3] (horizontal) - will return all paths
    //         getPaths[2, 1, 3, 3] (vertical) - will return all paths

    // Expectation <-> Faith ->
    //                          h + getPaths[1, 2, 3, 3] (horizontal)
    //                          v + getPaths[2, 1, 3, 3] (vertical)


    private static ArrayList<String> getPaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();

        if (sc < dc) {
            hPaths = getPaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            vPaths = getPaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String path: hPaths) {
            paths.add("h" + path);
        }

        for (String path: vPaths) {
            paths.add("v" + path);
        }

        return paths;
    }
}
