package com.home.leetcode_easy_collection;
/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
        - MinStack() initializes the stack object.
        - void push(int val) pushes the element val onto the stack.
        - void pop() removes the element on the top of the stack.
        - int top() gets the top element of the stack.
        - int getMin() retrieves the minimum element in the stack.
        - You must implement a solution with O(1) time complexity for each function.

Example 1:

        Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

        Output
        [null,null,null,null,-3,null,0,-2]

        Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2

Constraints:
        -231 <= val <= 231 - 1
        Methods pop, top and getMin operations will always be called on non-empty stacks.
        At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/
/*

Approach 1 -
        Maintain 2 stacks - Here it will O(1) constant time, but space will not be constant.
        allDataStack -
            - push all data
            - pop all data

        minDataStack -
            - push only min data, also push if stack is empty initially
            - pop only if data present on top

*/

import java.util.Stack;

public class MinimumStack_LC_155_I {
    Stack<Integer> allStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinimumStack_LC_155_I() {
    }

    public void push(int val) {
        allStack.push(val);

        if (minStack.size() == 0 || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (allStack.size() == 0) {
            return;
        } else {
            int val = allStack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return allStack.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) {
            return -1;
        } else {
            return minStack.peek();
        }
    }
}
