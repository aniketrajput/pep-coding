package com.home.arrays_and_string_level2;

/*

1. Given an array of size 'N' and element K
2. Task is to find all elements that appear more than N/K times in array.
3. Return these elements in ArrayList in sorted order.

*/

import java.util.*;

public class MajorityElementGeneral_K {
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                int frequency = hashMap.get(arr[i]);
                hashMap.put(arr[i], frequency + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }

        for (Integer key : hashMap.keySet()) {
            int frequency = hashMap.get(key);

            if (frequency > arr.length/k) {
                resultList.add(key);
            }
        }

        Collections.sort(resultList);

        return resultList;
    }

}
