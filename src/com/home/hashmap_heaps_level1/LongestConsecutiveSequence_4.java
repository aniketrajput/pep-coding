package com.home.hashmap_heaps_level1;

/*
We are given a array, it can contain multiple consecutive sequences, we need to print longest consecutive sequence amongst them.
If two sequence has same length then we print the sequence whose first char appears first in array
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence_4 {
    public static void findSequence() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter n1: ");
        int n1 = scan.nextInt();
        int arr[] = new int[n1];
        System.out.println("Enter n1 elements: ");
        for (int i = 0; i < n1; i++) {
            arr[i] = scan.nextInt();
        }

        Map<Integer, Boolean> hashmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashmap.put(arr[i], true);                      //Initially we set all elements value to true
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashmap.containsKey(arr[i]-1)) {
                hashmap.put(arr[i], false);             //if hashmap contains a key which is lesser by 1 than current element then it means current element is not a starting point, so set it as false
            }
        }       //after this loop in hashmap for all elements which are starting point will have value as true and rest as false


        int maxStartingPoint = 0;
        int maxLength = 0;

        for (int key: arr) {
            if (hashmap.get(key)) {         //if item in hashmap is true means it is a start of sequence
                int startingPoint = key;
                int length = 1;

                while(hashmap.containsKey(key + length)) {
                    length++;
                }                                                           //after this loop we have starting point of sequence and number of items (length) after this starting point

                if (length > maxLength) {                                   //if length of this sequence is greater than max length then this is a new larger sequence
                    maxStartingPoint = startingPoint;
                    maxLength = length;
                }
            }
        }

        for (int i = 0; i < maxLength; i++) {
            System.out.print(maxStartingPoint + i + " ");
        }

    }
}
