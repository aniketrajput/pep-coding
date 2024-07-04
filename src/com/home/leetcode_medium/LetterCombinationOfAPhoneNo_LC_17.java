package com.home.leetcode_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNo_LC_17 {

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if (digits.isEmpty()) {
            return results;
        }

        Map<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        backtrack(digits, 0, hashMap, new StringBuilder(), results);

        return results;
    }

    private static void backtrack(String digits, int i, Map<Character, String> hashMap, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {             //when i = 0, one letter will be there in sb, when i = 1 then two letters are there in sb and when i becomes 2 i.e. equal to digit length, we have got our answer
            ans.add(sb.toString());
            return;
        }

        String curr = hashMap.get(digits.charAt(i));

        for (int k = 0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            backtrack(digits, i + 1, hashMap, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/*

Check notes on Tablet

*/