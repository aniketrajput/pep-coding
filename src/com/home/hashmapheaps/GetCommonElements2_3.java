package com.home.hashmapheaps;

/*
You have two arrays, it can be unsorted, print common elements between them. Now here print all common elements i.e. same element if it is common multiple times then print it multiple times.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetCommonElements2_3 {
    public static void printCommonElements() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter n1: ");
        int n1 = scan.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter n1 elements: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scan.nextInt();
        }

        System.out.println("Enter n2: ");
        int n2 = scan.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Enter n2 elements: ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scan.nextInt();
        }

        Map<Integer, Integer> hashmap = new HashMap<>();        //In this question, requires maintaining a frequency map

        for (int i = 0; i < arr1.length; i++) {
            if (hashmap.containsKey(arr1[i])) {
                int val = hashmap.get(arr1[i]);
                hashmap.put(arr1[i], ++val);
            }
            else {
                hashmap.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (hashmap.containsKey(arr2[i]) && hashmap.get(arr2[i]) > 0) {         //if element is present in hashmap and its frequency is > 0 then only print
                System.out.print(arr2[i] + " ");
                int frequency = hashmap.get(arr2[i]);
                hashmap.put(arr2[i], --frequency);
            }
        }
    }
}
