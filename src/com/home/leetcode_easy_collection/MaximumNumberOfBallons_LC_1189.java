package com.home.leetcode_easy_collection;
/*

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
        Input: text = "nlaebolko"
        Output: 1

Example 2:
        Input: text = "loonbalxballpoon"
        Output: 2

Example 3:
        Input: text = "leetcode"
        Output: 0

Constraints:
        1 <= text.length <= 104
        text consists of lower case English letters only.

*/


import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallons_LC_1189 {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                int frequency = hashMap.getOrDefault(ch, 0);
                hashMap.put(ch, frequency + 1);
            }
        }

        int x = Math.min(hashMap.getOrDefault('b', 0), Math.min(hashMap.getOrDefault('a', 0), hashMap.getOrDefault('n', 0)));   //min ('b', 'a', 'n')
        int xx = Math.min(hashMap.getOrDefault('l', 0), hashMap.getOrDefault('o', 0));
        int answer = Math.min(xx/2, x);         // xx / 2 because we want 'l' and 'o' twice so a pair of it will be considered as a unit

        return answer;
    }

}

/*

- Store occurrences of 'b', 'a', 'l', 'o', 'n' in HashMap
        -  To create a text "balloon" we will require 'b' once, 'a' once, 'l' twice, 'o' twice and 'n' once
        - So minimum 1 time 'b', 'a', 'n' is required and 'l', 'o' minimum 2 times is required to create one "balloon" text
        - So minimum nos of either of these chars available those many text possible.
        eg -  we have 2 'b' so might be 2 texts possible but will also have to check if 2 'a' and 'n' and 4 'o' and 'n' present

*/
