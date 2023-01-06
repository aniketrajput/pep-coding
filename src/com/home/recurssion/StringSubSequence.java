package com.home.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringSubSequence {
    public static final Scanner scan = new Scanner(System.in);

    public static void findSubsequence() {
        System.out.println("Enter String: ");
        String str = scan.next();

        ArrayList<String> res = getSubSequence(str);
        System.out.println(res);
    }

    private static ArrayList<String> getSubSequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

    }
}
