package com.home.recurssion_backtracting_level_1;

import java.util.ArrayList;
import java.util.Scanner;

//Expection 678 - will return 24 strs. Faith is 78 will return 6 strs. EF - for each character of 6 combine with each of 6 strs, we will get total 24 strs.
public class GetKeypadCombination {
    public static final Scanner scan = new Scanner(System.in);

    public static void keypadCombination() {
        System.out.println("Enter String: ");
        String str = scan.next();

        ArrayList<String> res = getKeyPadCombination(str);
        System.out.println(res);
    }

    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static ArrayList<String> getKeyPadCombination(String str) {         //678
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);    //6
        String restOfString = str.substring(1); //78

        ArrayList<String> rres = getKeyPadCombination(restOfString);    //faith - 78 will give 6 combinations
        ArrayList<String> mres = new ArrayList<>();

        String codeForCh = codes[ch - '0']; //suppose ch is '7' then it is in char form to get it in numeric form we will have to subtract it by 48 or '0'

        for (int i = 0; i < codeForCh.length(); i++) {
            char chCode = codeForCh.charAt(i);
            for (String rstr: rres) {
                mres.add(chCode + rstr);
            }
        }

        return mres;
    }

}
