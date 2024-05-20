package com.home.hashmap_heaps_level_1;

/*

Implementing our own PriorityQueue.

If we use linked list, then we can add element as it comes at the end of list. This will give time complexity for add() - O(1)
But when we want to peek() and remove(), it will be time complexity of O(n) as we will have to find the element in entire list

So if while adding we add the elements at its proper way in sorted way, then add() will time complexity of O(n)
But remove() and peek() will have time complexity of O(1)

But third solution can be, add(), remove() should be in logn and peek in O(1). This will make the overall complexity of queue better.

Data structure used to implement PriorityQueue is called Heap. Heap is tree form.

Heap Order Property (HOP) - Parent will have higher priority than its children - means parent node will be smaller than child nodes. (PriorityQueue has high priority for lower values by default). Leftchild or right child can be anything, anyone can be big or small, just parent should be smallest.

This way root will always have higher priority element. So peek() can have O(1) complexity this way.

Complete Binary Tree Property (CBT) - Heap is binary tree. This property indicates that, heap's height-1 level should be completely filled. That is all node should be complete. Last level (height level) will start filling from left side.
Because of this property we can have logn complexity for add() and remove()
Because of this property we can visualize ArrayList as Binary tree.

Check notebook for diagram.

Visualize ArrayList as Binary tree. We can notice following relation -
	left-child-index = 2 * parent-index + 1
	right-child-index = 2 * parent-index + 2

By visualising ArrayList as Binary tree, we can also go from children to parent. In normal Binary tree we cannot go from child to parent, we can go parent to child but not child to parent -
	parent-index = child-index - 1 / 2

add() -
	While adding we will take care of both above properties. Suppose we added element keeping in mind COB but HOP is getting violated, then we need to swap it with parent.
	Suppose parent was 20, and we added 15 as its child keeping in mind COP then it violates HOP, swap them.
	Actual swap will happen in ArrayList only. (We have above formula to find index)

So we maintained the CBT rule, hence we were able to use ArrayList (as we were able to added elements one after another), due to ArrayList we were able to calculate indexes of parent while swapping required in add operation (UpHeapify), hence we were able to implement add() in logn

If this was not an ArrayList, and it was implemented like normal Binary tree, then find that spot to add new element we would have to traverse the tree using - level order traversal, pre post in order traversals, all are of O(n) complexity.


Now while removing, if we remove the first element of ArrayList, all elements are shifted, so it becomes O(n), last spot can be remove in O(1)
Swap first and last value, remove last.
But this will disturb the HOP, so we do downHeapify. Compare with both child, swap with child which is smaller. Keep swapping till height.
This will happen in logn as we downHeapify till height.

*/

import java.util.ArrayList;

public class PriorityQueueUsingHeap {
    ArrayList<Integer> heap;

    public PriorityQueueUsingHeap() {
        heap = new ArrayList<>();
    }

    public PriorityQueueUsingHeap(int[] arr) {                  //this constructor improves the time complexity
        heap = new ArrayList<>();
        for (int val: arr) {
            heap.add(val);
        }

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void add(int val) {
        heap.add(val);
        upHeapify(heap.size() - 1);
    }

    public int remove() {
        if (heap.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }

        swap(0, heap.size() - 1);
        int removed = heap.remove(heap.size() - 1);
        downHeapify(0);

        return removed;
    }

    public int peek() {
        if (heap.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }

        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    private void upHeapify(int childIndex) {
        if (childIndex == 0) {
            return;
        }
        int parentIndex = (childIndex - 1) / 2;
        if (heap.get(childIndex) < heap.get(parentIndex)) {
            swap(parentIndex, childIndex);
            upHeapify(parentIndex);
        }
    }

    private void swap(int parentIndex, int childIndex) {
        int pData = heap.get(parentIndex);
        int childData = heap.get(childIndex);
        heap.set(parentIndex, childData);
        heap.set(childIndex, pData);
    }

    private void downHeapify(int pIndex) {
        int leftChildIndex = 2 * pIndex + 1;
        int rightChildIndex = 2 * pIndex + 2;
        int temp = pIndex;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(temp)) {        //leftChildIndex < heap.size() -> left child index is within ArrayList and valid
            temp = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(temp)) {
            temp = rightChildIndex;
        }

        if (temp != pIndex) {               // this is the base case, where recursion will stop
            swap(pIndex, temp);
            downHeapify(temp);
        }
    }

}
