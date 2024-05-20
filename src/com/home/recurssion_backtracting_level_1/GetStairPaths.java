package com.home.recurssion_backtracting_level_1;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {

    public static final Scanner scan = new Scanner(System.in);

    public static void getStairsPath() {
        System.out.println("Enter number of stairs: ");
        int n = scan.nextInt();

        ArrayList<String> res = getPaths(n);
        System.out.println(res);
    }

    private static ArrayList<String> getPaths(int n) {
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");   //if you are on 0, then you are already there, double quote indicates it to be there.
            return bres;
        } else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();     //just empty list is returned because it is in negative and no path is possible.
            return bres;
        }

        ArrayList<String> path1 = getPaths(n-1);
        ArrayList<String> path2 = getPaths(n - 2);
        ArrayList<String> path3 = getPaths(n - 3);
        ArrayList<String> paths = new ArrayList<>();

        for (String path: path1) {
            paths.add("1" + path);
        }

        for (String path: path2) {
            paths.add("2" + path);
        }

        for (String path: path3) {
            paths.add("3" + path);
        }

        return paths;
    }


}
