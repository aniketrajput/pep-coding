package com.home.leetcode_easy_collection;

/*

Approach 2 - O(1) time and O(1) space
        Using one stack and min variable

        push() -
            If value to be pushed is smaller than min, then in stack push => value + (value - min). This will push data which is smaller than actual original value.
            We stored fake value in stack and original value stored in min.
            Such points in stack can be identified or there is a detection flag that - value in stack is smaller than value in min, then it is a fake value scenario and we had updated min.


        getMin() -
            return min variable value

        pop() -
            if value in stack is greater than or equal min then that is real value, return
            if value in stack is smaller than min then it is a fake value stored, original value was stored in min, so return min.
            Now min should be restored to previous min, so min = 2 * min - data.pop()

*/


import java.util.Stack;

public class MinimumStack_LC_155_II {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinimumStack_LC_155_II() {
    }

    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(val);
            min = val;
        }
        else if (val >= min) {
            stack.push(val);
        }
        else {
            stack.push(val + val - min);
            min = val;
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        }
        else {
            if (stack.peek() >= min) {
                stack.pop();
            }
            else {      //jhool kiya tha
                int val = min;      //this was the original value, can return this if required
                min = 2 * min - stack.pop();        //calculated previous min and also popped from stack
            }
        }
    }

    public int top() {
        if (stack.size() == 0) {
            return -1;
        }
        else if (stack.peek() >= min) {
            return stack.peek();
        }
        else {                  //jhool kiya tha, original value was stored in min
            return min;
        }
    }

    public int getMin() {
        if (stack.size() == 0) {
            return -1;
        } else {
            return min;
        }
    }

}
