package com.home.hashmapheaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
You have two arrays, it can be unsorted, print common elements between them. Common element should get printed only once.
*/

public class GetCommonElements1_2 {
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

        Map<Integer, Integer> hashmap = new HashMap<>();        //In this question, there is no need for maintaining a frequency map, we can maintain a boolean value as well, or KeyMap where only keys are there

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
            if (hashmap.containsKey(arr2[i])) {
                System.out.print(arr2[i] + " ");
                hashmap.remove(arr2[i]);
            }
        }
    }

}
