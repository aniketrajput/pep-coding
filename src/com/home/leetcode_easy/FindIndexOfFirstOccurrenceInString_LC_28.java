package com.home.leetcode_easy;
/*

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation: "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.

Example 2:
        Input: haystack = "leetcode", needle = "leeto"
        Output: -1
        Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
        1 <= haystack.length, needle.length <= 104
        haystack and needle consist of only lowercase English characters.

*/

/*

haystack.length() - needle.length() + 1 =>

    haystack - butputsad        needle - sad

    Length of needle is 3, so needle cannot come in haystack after 6th index, the last occurrence of needle in haystack can be from 6th - 8th index only, it will start from 6th index.
    So after 6th index no need to iterate.

*/

public class FindIndexOfFirstOccurrenceInString_LC_28 {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }



    //Alternate solution =>

    public int strStr2(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                if (compareStr(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean compareStr(String haystack, String needle, int idx) {

        for (int i = 0; i < needle.length(); i++) {
            if (haystack.length() <= idx) {                     //haystack = textbook;  needle = booklistomi
                return false;
            }

            if (needle.charAt(i) != haystack.charAt(idx)) {
                return false;
            } else {
                idx++;
            }
        }
        return true;
    }

}
/*

haystack.length() - needle.length() + 1 =>

    haystack - butputsad        needle - sad

    Length of needle is 3, so needle cannot come in haystack after 6th index, the last occurrence of needle in haystack can be from 6th - 8th index only, it will start from 6th index.
    So after 6th index no need to iterate.

*/
