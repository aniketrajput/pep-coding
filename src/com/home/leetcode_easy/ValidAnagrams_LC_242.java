package com.home.leetcode_easy;
/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:

        Input: s = "rat", t = "car"
        Output: false


        Constraints:

        1 <= s.length, t.length <= 5 * 104
        s and t consist of lowercase English letters.

*/


import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidAnagrams_LC_242 {
    public static boolean isAnagram(String s, String t) {

        /*
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String sortedS = String.valueOf(charArr);
        */

        String sortedS = Arrays.stream(s.split("")).sorted().collect(Collectors.joining(""));
        String sortedT = Arrays.stream(t.split("")).sorted().collect(Collectors.joining(""));

        if (sortedS.equals(sortedT))
            return true;
        else
            return false;
    }

}
