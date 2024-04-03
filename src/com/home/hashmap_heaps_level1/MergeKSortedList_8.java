package com.home.hashmap_heaps_level1;

/*
Provided K sorted lists. Merge all list together and return single sorted list.

public class Pair implements Comparable {
	int listIndex;		//you are from which list
	int dataIndex;		//what is your index
	int val;			//what is your value

	public int compareTo(Pair o) {			//if it returns +ve value then this is >, -ve this is <, 0 then equal
		return this.val - o.val;
	}

}

PriorityQueue depends on Comparable. If data is Integer then it can use < but if comparison is between two custom objects then PriorityQueue will use compareTo() of Comparable.
Suppose, there are two Pair objects in PriorityQueue p1 and p2. PriorityQueue wants to know which is smaller for peek(). So it will type cast these objects into Comparable class, in this way compareTo() will be available for those objects -
		Comparable o1 = (Comparable)p1;
		Comparable o2 = (Comparable)p2;

		if(o1.compareTo(o2) < 0)
			...then ò1 is smaller
		else
			o2 is smaller
*/

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedList_8 {

    public static ArrayList<Integer> merge() {
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = acceptData();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {                               //add first element of all lists to priority queue
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
        }

        while (!pq.isEmpty()) {
            Pair p = pq.remove();      //don't peek(), remove that item from queue
            resultList.add(p.val);

            p.di++;                  //we need to insert next element after current di from this same list in queue.

            if (p.di < lists.get(p.li).size()) {      //check if next element index is less than size of that list
                p.val = lists.get(p.li).get(p.di);      //get the value of new di
                pq.add(p);
            }
        }

        return resultList;
    }

    public static ArrayList<ArrayList<Integer>> acceptData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            System.out.println("Enter n: ");
            int n = scanner.nextInt();

            System.out.println("Enter n elements: ");
            for (int j = 0; j < n; j++) {
                int v = scanner.nextInt();
                list.add(v);
            }
            lists.add(list);
        }

        return lists;
    }

}

class Pair implements Comparable<Pair>{
    int li;		                //listIndex - you are from which list
    int di;		                //dataIndex - what is your index
    int val;			        //val - what is your value

    public Pair(int li, int di, int val) {
        this.li = li;
        this.di = di;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {          //if it returns +ve value then this is >, -ve this is <, 0 then equal
        return this.val - o.val;
    }
}


