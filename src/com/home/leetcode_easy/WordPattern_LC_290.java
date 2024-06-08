package com.home.leetcode_easy;

/*

Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true

Example 2:
        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false

Example 3:
        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false

Constraints:
        1 <= pattern.length <= 300
        pattern contains only lower-case English letters.
        1 <= s.length <= 3000
        s contains only lowercase English letters and spaces ' '.
        s does not contain any leading or trailing spaces.
        All the words in s are separated by a single space.

*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern_LC_290 {

    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");

        if (pattern.length() != sArr.length) {
            return false;
        }

        Map<Character, String> hashMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            if (hashMap.containsKey(pattern.charAt(i))) {
                String value = hashMap.get(pattern.charAt(i));

                if (!value.equals(sArr[i])) {
                    return false;
                }
            }
            else {
                if (hashMap.containsValue(sArr[i])) {                //Value is already mapped with some different character   //pattern - abba    s - dog dog dog dog
                    return false;
                }
                hashMap.put(pattern.charAt(i), sArr[i]);
            }
        }

        return true;
    }

}











