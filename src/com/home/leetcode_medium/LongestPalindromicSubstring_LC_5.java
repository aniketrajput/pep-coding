package com.home.leetcode_medium;

/*

Given a string s, return the longest palindromic substring in s.

Example 1:
        Input: s = "babad"
        Output: "bab"

        Explanation: "aba" is also a valid answer.

Example 2:
        Input: s = "cbbd"
        Output: "bb"

Constraints:
        1 <= s.length <= 1000
        s consist of only digits and English letters.

*/


public class LongestPalindromicSubstring_LC_5 {

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        String longestPalindromicSubstring = "";

        for (int i = 1; i < s.length(); i++) {

            //Consider odd length
            int left = i;
            int right = i;

            //Keep extending in both left and right directions till the conditions for a palindrome are met
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;

                //Terminate condition if we reach the end/start of the string
                if (left == -1 || right == s.length())
                    break;
            }

            //Indexes left and right can be used to extract the palindrome substring
            String palindrome = s.substring(left+1, right);
            if (longestPalindromicSubstring.length() < palindrome.length()) {
                //Capture the longest Palindrome found
                longestPalindromicSubstring = palindrome;
            }

            //Consider even length
            left = i - 1;
            right = i;

            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;

                if (left == -1 || right == s.length())
                    break;
            }

            palindrome = s.substring(left+1, right);
            if (longestPalindromicSubstring.length() < palindrome.length()) {
                //Similarly, keep track of the longest even length palindrome
                longestPalindromicSubstring = palindrome;
            }

        }

        return longestPalindromicSubstring;
    }

}

/*

- Pickup a character from a string and navigate to its left and right one character each
- If it is still a palindrome we can again navigate to its left and right
- We will stop as soon we hit the end of the string or corners of the string, or we get string that is no longer a palindrome
- So basic idea here is to traverse each character, navigate to its left and right and find the longest possible palindrome

*/
