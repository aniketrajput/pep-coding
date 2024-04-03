package com.home.arrays_and_string_level2;

/*

Check notebook for analysis.

There can be only one element with more than half frequency. That is why we find potential candidate.
In potential candidate we may get element with maximum frequency in array, but that frequency may not be greater than half of array.
That is why we again find the frequency of potential candidate we got and compare it with half of array count.

1. Given an array of size 'n'.
2. Find Majority element and print if (if exists), otherwise print 'No Majority Element exists.'
3. Majority element => if frequency of an element is more than n/2, then that element is existed in majority.

Input format -
    [2, 2, 1, 1, 1, 2, 2]

Output format -
    2

Input format -
    [1, 1, 5, 5, 3, 6]

Output format -
    No Majority Element exists.

*/

public class MajorityElement_1 {

    public static void printMajorityElement(int[] arr) {
        int potentialCandidate = findPotentialCandidate(arr);
        int potentialCandidateCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == potentialCandidate) {
                potentialCandidateCount++;
            }
        }

        if (potentialCandidateCount > arr.length / 2) {
            System.out.println("Majority Element = " + potentialCandidate);
        }
        else {
            System.out.println("No Majority Element exists.");
        }
    }

    private static int findPotentialCandidate(int[] arr) {
        int value = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (value == arr[i]) {
                count++;            //same element increment the frequency
            }
            else {
                count--;            //distinct element, map it with value
            }

            if (count == 0) {       //count becomes 0, then give current element chance.
                value = arr[i];
                count = 1;
            }
        }

        return value;
    }

}
