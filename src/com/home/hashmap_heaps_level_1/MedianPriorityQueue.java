package com.home.hashmap_heaps_level_1;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Example -
	10 20 30
		when peek() done return median as 20
		old number of elements will have one median

	10 20 30 40
		there are two median here now 20 and 30, when peek() done return the smallest i.e. 20
		even number of elements will have two median, return smaller one

	remove() should remove median as that is peek()

	left queue -
		Will have smaller half of data.
		This is a max priority queue, means it will have larger number in peek().
	right queue -
		Will have greater half of data
		This is a min priority queue, means it will have smaller number in peek().

	Take care that difference between number of items in both queues is not more than 1. If it happens balance them.

	By default, insert in left queue.

	peek() -
	if left size is greater than right, return from left
	if left and right size are same, return from left
	if right size is greater than left, return from right

	remove() -
		if left size is greater than right, remove from left
		if left and right size are same, remove from left
		if right size is greater than left, remove from right

	add() -
		generally add in left queue
		If there is an item in right queue and current item is greater than its peek(), if yes, then add in right but as soon as you add in right you need to balance it, if gap is more than one then balance.
*/

public class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }

    public void add(int val) {
        if (right.size() > 0 && val > right.peek()) {
            right.add(val);
        }
        else {
            left.add(val);
        }

        if (left.size() - right.size() == 2) {
            right.add(left.remove());
        }
        else if (right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }

    public int peek() {
        if (this.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }
        else if (left.size() >= right.size()) {
            return left.peek();
        }
        else {
            return right.peek();
        }
    }

    public int remove() {
        if (this.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }
        else if (left.size() >= right.size()) {
            return left.remove();
        }
        else {
            return right.remove();
        }
    }

    public int size() {
        return left.size() + right.size();
    }
}
