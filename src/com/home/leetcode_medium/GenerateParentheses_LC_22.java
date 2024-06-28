package com.home.leetcode_medium;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
        Input: n = 1
        Output: ["()"]

Constraints:
        1 <= n <= 8

*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_LC_22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, 0, 0, "");
        return result;
    }

    private void generate(List<String> result, int n, int open, int close, String unProcessed) {
        if (unProcessed.length() == 2 * n) {        //One output combination will always be 2 * n
            result.add(unProcessed);
            return;
        }

        if (open < n) {
            generate(result, n, open + 1, close, unProcessed + "(");
        }

        if (close < open) {         //close < open because it should be balanced parentheses
            generate(result, n, open, close + 1, unProcessed + ")");
        }
    }

}

/*

https://www.youtube.com/watch?v=u_Zmx9cLHjk

Key-points -
    - All combination is balanced
    - One output combination will always be 2 * n
        = 2n => n (opening braces) + n (closing braces)
    - Opening parenthesis followed by closing parenthesis


    If problem asks for all the possible combinations then we have to use recursion.
    Try to draw recursion tree and then code it.

    Check Notebook for Recursion tree diagram
*/
