package com.home.leetcode_easy;

/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
        Input: s = "aba"
        Output: true

Example 2:
        Input: s = "abca"
        Output: true
        Explanation: You could delete the character 'c'.

Example 3:
        Input: s = "abc"
        Output: false

Constraints:
        1 <= s.length <= 105
        s consists of lowercase English letters.

*/

public class ValidPalindrome_II_LC_680 {

    public boolean validPalindrome(String s) {
         int left = 0;
         int right = s.length() - 1;

         while (left <= right) {
             if (s.charAt(left) == s.charAt(right)) {
                 left++;
                 right--;
             }
             else {
                 return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
             }
         }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*

Brute Force
    Delete each alphabet and in every iteration check if it is a palindrome

Two Pointers approach
        - One pointer at the start and one at the end
        - If both characters are same, move P1 ahead and move P2 backwards
        - If both characters are not same, then there are two options available -
        - Remove character at P1 or remove character at P2
        - So we can first remove P1 character and check if it is becoming Palindrome, if yes then good, if no then we have one more string to check, remove P2 character and check if it is becoming palindrome, if yes good else false


        Time - O(n)
        Space - O(1)

*/
