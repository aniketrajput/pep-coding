package com.home.leetcode_medium;

/*

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
        Input: s = "applepenapple", wordDict = ["apple","pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.

Example 3:
        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false

Constraints:
        1 <= s.length <= 300
        1 <= wordDict.length <= 1000
        1 <= wordDict[i].length <= 20
        s and wordDict[i] consist of only lowercase English letters.
        All the strings of wordDict are unique.

*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_LC_139 {
    Map<String, Boolean> dpMap = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) {
            return true;
        }

        if(dpMap.containsKey(s)) {
            return dpMap.get(s);
        }

        int n = s.length();

        for(int i = 1; i < n; i++) {
            String left = s.substring(0, i);

            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                dpMap.put(s, true);
                return true;
            }
        }

        dpMap.put(s, false);
        return false;
    }
}



/*
https://www.youtube.com/watch?v=LPs6Qo5qlJM

public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) {
            return true;
        }

        int n = s.length();

        for(int i = 1; i < n; i++) {
            String left = s.substring(0, i);

            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                return true;
            }
        }

        return false;
}


This is a correct recurssive solution but it leads to Time Limit Exceed error for big test cases on Leetcode.

Consider example - s => aaaaaab		wordDict => {a, aa, aaa}
	can be split as - 	a | aaaaab				aaaaab can be further split as  a| aaaab 	//we already solve aaaab left side
						aa | aaaab												aa| aaab	//already solve left side
						aaa | aaab

So here we are solving same problem again and again. So this can be solved using Dynammic programming. We can do it either by using array or map.

*/
