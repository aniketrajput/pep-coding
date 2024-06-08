package com.home.leetcode_easy;
/*

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
        Input: s = "egg", t = "add"
        Output: true

Example 2:
        Input: s = "foo", t = "bar"
        Output: false

Example 3:
        Input: s = "paper", t = "title"
        Output: true

Constraints:
        1 <= s.length <= 5 * 104
        t.length == s.length
        s and t consist of any valid ascii character.

*/

import java.util.HashMap;

public class IsomorphicStrings_LC_205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char originalChar = s.charAt(i);
            char replacementChar = t.charAt(i);

            if (!hashMap.containsKey(originalChar)) {                   //hashmap doesn't contain originalCh as key, but before insert also check replacementCh in values
                if (!hashMap.containsValue(replacementChar)) {          //hashmap doesn't contain replacementCh in values, so now insert
                    hashMap.put(originalChar, replacementChar);
                }
                else {                                                  //hashmap already contains replacementCh in values, so cannot map this value to new key, return false
                    return false;
                }
            }
            else {                                                              //hashmap already contains key, check if corresponding mapped value and replacementCh are same, if not return false
                    if (hashMap.get(originalChar) != replacementChar) {
                        return false;
                    }
            }
        }

        return true;
    }
}

/*

In HashMap, you will not only have to check the keys, you need to check values as well, this is the corner case -
        b a d c
        k i k p

While inserting a value in HashMap check if that value is present in keys as well as in values

Time - O(N) - because we iterate through original string
Space - O(1) - because we need a constant space in a HashMap, since Characters are Ascii character, max characters can be 256 which is constant space.

*/













