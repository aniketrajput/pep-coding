package com.home.leetcode_easy_collection;

/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.

Example 3:
        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
        1 <= s.length <= 2 * 105
        s consists only of printable ASCII characters.

*/

public class ValidPalindrome_LC_125 {

    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char startCh = Character.toLowerCase(s.charAt(start));
            char endCh = Character.toLowerCase(s.charAt(end));

            if (!Character.isLetterOrDigit(startCh)) {
                start++;
            }
            else if (!Character.isLetterOrDigit(endCh)) {
                end--;
            }
            else {
                if (startCh != endCh) {
                    return false;
                }
                else {
                    start++;
                    end--;
                }
            }
        }

        return true;
    }

}

/*

Complexity

Time complexity:
        The time complexity of this solution is O(n), where n is the length of the string. This is because, in the worst case, all characters in the string need to be checked once, so the number of operations is proportional to the length of the string.

Space complexity:
        The space complexity of this solution is O(1), as no additional data structures are used, and only a constant amount of memory is required for the start and last pointers and a few variables.

*/
