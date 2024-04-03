package com.home.hashmap_heaps_level1;

import java.util.HashMap;
import java.util.Map;

/*
Find character from provided string will the highest frequency count.
*/

/*
Hashmap
	put() - if key present then will replace
	get() - if key not present then will return null
	containsKey() - returns true or false
	keySet() - returns all keys in a Set

	Set<String> keys = hm.keySet();
	for(String key: hm.keySet()) {
		Integer val = hm.get(key);
	}

	Hashmap can insert anywhere. Order we cannot control. It is not sequential order.
*/


public class HighestFrequencyCharacter_1 {
    public static Character findChar(String str) {
        Map<Character, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (hashmap.containsKey(ch)) {
                int val = hashmap.get(ch);
                hashmap.put(ch, ++val);
            }
            else {
                hashmap.put(ch, 1);
            }
        }

        char hfChar = str.charAt(0);       //assuming that first char in string is the highest frequency character
        for (char key : hashmap.keySet()) {
            if (hashmap.get(key) > hashmap.get(hfChar)) {
                hfChar = key;
            }
        }

        return hfChar;
    }
}
