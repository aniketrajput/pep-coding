package com.home.hashmap_heaps_level_1.genericpriorityqueue;

/*

Just like Java PriorityQueue, here we have implemented a generic Priority Queue, it can hold any type of custom objects like Student.
Providing a Comparable compareTo() method is important, because while upHeapify and downHeapify our logic need to compare child and parent nodes, as these are custom objects we need to provide compareTo() method.
Additionally, we can also provide Comparator compare() method if we want to support comparison on additional properties.

*/


import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueueUsingGenericHeap<T> {
    ArrayList<T> heap;
    Comparator comparator;

    public PriorityQueueUsingGenericHeap() {
        heap = new ArrayList<>();
        comparator = null;
    }

    public PriorityQueueUsingGenericHeap(Comparator comparator) {
        heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private boolean isSmaller(int childIndex, int parentIndex) {
        if (comparator == null) {                                           //this means on Comparator object was passed, so comparison should happen on Comparable compareTo()
            Comparable child = (Comparable) heap.get(childIndex);
            Comparable parent = (Comparable) heap.get(parentIndex);

            if (child.compareTo(parent) < 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            T child = heap.get(childIndex);
            T parent = heap.get(parentIndex);

            if (comparator.compare(child, parent) < 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void add(T val) {
        heap.add(val);
        upHeapify(heap.size() - 1);
    }

    public T remove() {
        if (heap.size() == 0) {
            System.out.println("Underflow");
            return null;
        }

        swap(0, heap.size() - 1);
        T removed = heap.remove(heap.size() - 1);
        downHeapify(0);

        return removed;
    }

    public T peek() {
        if (heap.size() == 0) {
            System.out.println("Underflow");
            return null;
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
        if (isSmaller(childIndex, parentIndex)) {
            swap(parentIndex, childIndex);
            upHeapify(parentIndex);
        }
    }

    private void swap(int parentIndex, int childIndex) {
        T pData = heap.get(parentIndex);
        T childData = heap.get(childIndex);
        heap.set(parentIndex, childData);
        heap.set(childIndex, pData);
    }

    private void downHeapify(int pIndex) {
        int leftChildIndex = 2 * pIndex + 1;
        int rightChildIndex = 2 * pIndex + 2;
        int temp = pIndex;

        if (leftChildIndex < heap.size() && isSmaller(leftChildIndex, temp)) {        //leftChildIndex < heap.size() -> left child index is within ArrayList and valid
            temp = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && isSmaller(rightChildIndex, temp)) {
            temp = rightChildIndex;
        }

        if (temp != pIndex) {               // this is the base case, where recursion will stop
            swap(pIndex, temp);
            downHeapify(temp);
        }
    }

}

