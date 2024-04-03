package com.home.arrays_and_string_level2;

/*

Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.

Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.

Solution -
- Iterate i over name string and j over typed string.
- if ith char and jth char are same, i++ and j++
- if ith char and jth char are not same, then check if jth char and i-1 th char are same. If yes, then key was long pressed, just do j++. If no, then return false as both are not matching.

Corner cases -
- If ith char and jth char are not same and i = 0 then checking i-1 th char will throw IndexOutOfBoundException, so check if i > 0 (name = aab, typed= bb)
- While iterating suppose ith index becomes > name.length(), and jth index is still < typed.length() then handle extra chars in typed in a separate loop. Check if extra chars are same as i-1,
if not return false (name = aabbc, typed= aabbccd)
- Suppose jth index becomes > typed.length(), and ith index is still < name.length() then both strings will never be same, return false (name = aabbcc, typed= aaabbb)

*/


public class FaultyKeyboardLeetcode925 {

    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length())             //if name is greater than typed, both can never be same
            return false;

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {               //traverse till both string ends. Valid cases will be - either both string ends together. And another can be name was completely traversed but some chars left in typed, these extra chars can be named last char
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            else if (i > 0 && name.charAt(i-1) == typed.charAt(j)) {
                j++;
            }
            else {
                return false;
            }
        }

        while (j < typed.length()) {                        //If in above loop named was traversed completely but typed has come chars remaining. Loop will break as named over. Handle those extra chars of typed here
            if (name.charAt(i-1) == typed.charAt(j)) {
                j++;
            }
            else {
                return false;
            }
        }

        return i < name.length() ? false : true;            //if at the end extra char in named remaining, they are not same return false
    }

}





















