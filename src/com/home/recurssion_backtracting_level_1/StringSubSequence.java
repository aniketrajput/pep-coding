package com.home.recurssion_backtracting_level_1;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSubSequence {
    public static final Scanner scan = new Scanner(System.in);

    public static void findSubsequence() {
        System.out.println("Enter String: ");
        String str = scan.next();

        ArrayList<String> res = getSubSequence(str);
        System.out.println(res);
    }

    //Check book for expectation and Faith
    private static ArrayList<String> getSubSequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);    //a
        String restOfStr = str.substring(1);  //bc
        ArrayList<String> rres = getSubSequence(restOfStr);

        ArrayList<String> mres = new ArrayList<>();
        for (String rstr: rres) {
            mres.add("" + rstr);
        }

        for (String rstr: rres) {
            mres.add(ch + rstr);
        }
        return mres;
    }
}
