package com.home.leetcode_easy;
/*

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
Implement the MyStack class:

        - void push(int x) Pushes element x to the top of the stack.
        - int pop() Removes the element on the top of the stack and returns it.
        - int top() Returns the element on the top of the stack.
        - boolean empty() Returns true if the stack is empty, false otherwise.

Notes:
        You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
        Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

Example 1:
        Input
        ["MyStack", "push", "push", "top", "pop", "empty"]
        [[], [1], [2], [], [], []]
        Output
        [null, null, null, 2, 2, false]

        Explanation
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False

Constraints:
        1 <= x <= 9
        At most 100 calls will be made to push, pop, top, and empty.
        All the calls to pop and top are valid.

*/

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_LC_225 {
/*

    //2 Queue Approach =>

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public ImplementStackUsingQueue_LC_225() {

    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        int res = q1.poll();

        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;

        return res;
    }

    public int top() {
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        int res = q1.poll();
        q2.add(res);

        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;

        return res;
    }

    public boolean empty() {
        if (q1.size() == 0 && q2.size() == 0)
            return true;
        else
            return false;
    }

    */


    //Single Queue Approach =>

    Queue<Integer> q1 = new LinkedList<>();

    public ImplementStackUsingQueue_LC_225() {

    }

    public void push(int x) {
        q1.add(x);

        for (int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}


/*

Queue - FIFO (First In First Out)

Stack - LIFO (Last In First OOut)

        queue.add(10) - 	| | |10| | |

        queue.add(30) - 	| | |10|30| |

        queue.add(50) - 	| | |10|30|50|

        queue.add(60) - 	| | |10|30|50|60

        queue.poll() - 10	| | | |30|50|60 				//10 came in first so it will be first to get out

        queue.poll() - 30	| | | | |50|60

Method 1 - Using 2 Queues
        Push -
            - Just enqueue the elements in q1

        Pop -
            - Count elements in q1 - (n)
            - For (n-1) time do this:
            - Dequeue from q1 and enqueue to q2
            - Dequeue from q1 and print
            - Swap q1 and q2

        isEmpty -
            - Check if both queues are empty

Method 2 - Using Single Queues
        Push -
            - Add the element to q1
            - If the size of queue is 1, don't do anything
            - If queue size is greater than 1, let us say (size = n)
            - For (n - 1) times:
            -- Dequeue from q1 and enqueue it back to q1

        Pop:
            - Just dequeue from q1

        Time - O(n) - when you push it will take sometime to remove elements and then add it back to queue. Other operations like pop, top, isEmpty happens in O(1) times.
        Space - O(n) - We need extra space to maintain a queue

If we are doing a lot of push operations then we should go with Method-1, if we are doing lot of pop operations then we should go with Method-2


*/
