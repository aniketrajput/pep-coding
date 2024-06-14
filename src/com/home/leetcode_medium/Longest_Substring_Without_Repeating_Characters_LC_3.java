package com.home.leetcode_medium;
/*

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
        Input: s = "abcabcbb"
        Output: 3

        Explanation: The answer is "abc", with the length of 3.

Example 2:
        Input: s = "bbbbb"
        Output: 1

        Explanation: The answer is "b", with the length of 1.

Example 3:
        Input: s = "pwwkew"
        Output: 3

        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.

*/

import java.util.ArrayList;
import java.util.List;

public class Longest_Substring_Without_Repeating_Characters_LC_3 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;

        List<Character> list = new ArrayList<>();

        while (end < s.length()) {
            if (!list.contains(s.charAt(end))) {
                list.add(s.charAt(end));
                end++;

                length = Math.max(length, list.size());
            }
            else {
                list.remove(Character.valueOf(s.charAt(start)));    //if we don't use Character.valueOf(), it will take ascii value of character, and we will IndexOutOfBoundException
                start++;
            }
        }

        return length;
    }

}


//Dry run the code