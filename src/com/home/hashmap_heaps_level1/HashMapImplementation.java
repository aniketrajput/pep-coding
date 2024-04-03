package com.home.hashmap_heaps_level1;

/*

HashMap can be implemented as Array of LinkedLists. Each element of Array is called bucket. Each bucket will have a LL and multiple node in it. Check notebook.

hash() - we pass key to it, and it tells its bucket index

put() -
	call hash() and pass key - will return bucket index
	loop in bucket and search in that bucket list for key, if present replace
	If not present add to list

Suppose, n is total number of elements in all buckets (8). N is number of buckets (4). Then lambda = n/N. Lambda is also called Loading Factor. It is average elements per bucket.
So time complexity of put(), get(), remove(), containsKey() is O(lambda) because it will compare with elements in one bucket.
Lambda is always <= K, where K is some threshold value.

containsKey() -
	call hash(), will let you know the bucket index, search in that bucket, if you find it return true or else false.

get() -
	call hash, will let you know the bucket index, search in that bucket, if you find it return value or else null.

remove() -
	call hash, will let you know the bucket index, search in that bucket, if you find it return value and remove from that list or else null.

size() -
	small n is our size

keySet() -
	loop all bucket, add and return

While put() if insert is happening then n will increase, then lambda will also grow, so immediately check if lambda > K, if lambda becomes greater than K then rehashing activity will happen.
Rehashing means -  a new Array will be created of double size of previous Array. Due to this lambda will be calculated and will again be <= K. And all node from previous Array will be inserted in new Array.

*/

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation<K, V>{
    private class HMNode {
        K key;
        V value;

        public HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HMNode>[] buckets;
    private int size;

    public HashMapImplementation() {
        initBuckets(4);
        size = 0;
    }

    private void initBuckets(int N) {
        buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bucketIndex = hashfn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex != -1) {
            HMNode node = buckets[bucketIndex].get(dataIndex);
            node.value = value;
        }
        else {
            HMNode node = new HMNode(key, value);
            buckets[bucketIndex].add(node);
            size++;
        }

        double lambda = size * 1.0 / buckets.length;        //did size * 1.0 to convert it to double
        if (lambda > 2.0) {
            try {
                rehash();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void rehash() throws Exception{
        LinkedList<HMNode>[] oldBucket = buckets;
        initBuckets(oldBucket.length * 2);

        for (int i = 0; i < oldBucket.length; i++) {
            for (HMNode node : oldBucket[i]) {
                put(node.key, node.value);              //this put will use hashfn and distribute nodes in different buckets
            }
        }
    }

    private int hashfn(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    public V get(K key) {
        int bucketIndex = hashfn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex != -1) {
            HMNode node = buckets[bucketIndex].get(dataIndex);
            return node.value;
        }
        else {
            return null;
        }
    }

    private int getIndexWithinBucket(K key, int bucketIndex) {
        int dataIndex = 0;

        for (HMNode node : buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                return dataIndex;
            }
            dataIndex++;
        }
        return -1;
    }

    public boolean containsKey(K key) {
        int bucketIndex = hashfn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public V remove(K key) {
        int bucketIndex = hashfn(key);
        int dataIndex = getIndexWithinBucket(key, bucketIndex);

        if (dataIndex != -1) {
            HMNode node = buckets[bucketIndex].remove(dataIndex);
            size--;
            return node.value;
        }
        else {
            return null;
        }
    }

    public ArrayList<K> keySet() throws Exception {
        ArrayList<K> keys = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i]) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i]) {
                System.out.println(node.key + " -> " + node.value);
            }
        }
    }
}
