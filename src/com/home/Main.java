package com.home;

import com.home.arrays_and_string_level_2.MinimumNumberOfPlatform;
import com.home.binary_trees_level_1.ConstructBinaryTree;
import com.home.binary_trees_level_1.DisplayBinaryTree;
import com.home.binary_trees_level_1.Node;
import com.home.leetcode_easy_collection.MaximumSubArray_LC_53;
import com.home.leetcode_easy_collection.TwoSumII_LC_167;
import com.home.programs.Java_8_Syntax;
import com.home.searching_sorting.MinimumInSortedRotatedArray_LC_153;
import com.home.searching_sorting.SearchInRotatedArray_LC_33;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        //        ---------------------------------------Binary Trees L1------------------------------------------------------------------------------

//        Node root = ConstructBinaryTree.constructBinaryTree();
//        DisplayBinaryTree.display(root);

//        ---------------------------------------Arrays and Strings L2------------------------------------------------------------------------------
        /*System.out.println(FaultyKeyboardLeetcode925.isLongPressedName("alex", "aaleex"));
        System.out.println(FaultyKeyboardLeetcode925.isLongPressedName("saeed", "ssaaedd"));*/

        /*int[][] queries = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };

        RangeAdditionLC370.getModifiedArray(5, queries);*/

//        MajorityElement_1.printMajorityElement(new int[] {2, 2, 2, 1, 1, 1});

        /*ArrayList resultList = MajorityElementGeneral_K.majorityElement(new int[] {3, 1, 2, 2, 1, 2, 3, 3}, 4);
        System.out.println(resultList);*/


//        ----------------------------------------------HASHMAP AND HEAPS--------------------------------------------------------------------

        /*
        char hfcChar = HighestFrequencyCharacter_1.findChar("babcccdbabcccd");
        System.out.println("Highest Frequency Character: " + hfcChar);
        */

//        GetCommonElements1_2.printCommonElements();

//        GetCommonElements2_3.printCommonElements();

//        LongestConsecutiveSequence.findSequence();

//        PriorityQueueExample_5.displayPriorityQueue();

//        KthLargestInArray_6.findKthLargest();

//        SortKSortedArray_7.sort();

        /*MedianPriorityQueue mpq = new MedianPriorityQueue();
        mpq.add(10);
        mpq.add(20);
        mpq.add(30);
        System.out.println(mpq.peek());
        mpq.add(40);
        System.out.println(mpq.peek());
        mpq.add(50);
        System.out.println(mpq.peek());*/

        /*ArrayList<Integer> resultList = MergeKSortedList_8.merge();
        System.out.println(resultList);*/

        /*PriorityQueueUsingHeap.add(20);
        PriorityQueueUsingHeap.add(30);
        PriorityQueueUsingHeap.add(10);
        PriorityQueueUsingHeap.add(40);
        System.out.println(PriorityQueueUsingHeap.peek());
        PriorityQueueUsingHeap.add(5);
        PriorityQueueUsingHeap.add(45);
        PriorityQueueUsingHeap.add(55);
        System.out.println(PriorityQueueUsingHeap.peek());
        System.out.println(PriorityQueueUsingHeap.remove());*/

        /*PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap(new int[] {20, 30, 10, 40});
        System.out.println(pq.peek());*/

        /*HashMapImplementation hm = new HashMapImplementation<>();
        hm.put("India", 500);
        hm.put("China", 50);
        hm.put("US", 100);
        hm.put("UK", 150);
        hm.put("Germany", 300);
        hm.put("Ireland", 350);
        hm.put("Canada", 450);
        hm.display();
        hm.put("UK", 200);
        System.out.println("---------------------");
        System.out.println(hm.remove("Canada"));
        System.out.println("---------------------");
        System.out.println(hm.get("Ireland"));
        System.out.println("---------------------");
        System.out.println(hm.containsKey("Germany"));
        System.out.println("---------------------");
        hm.display();*/
/*

        Student s1 = new Student(1, 180, 100);
        Student s2 = new Student(2, 190, 120);
        Student s3 = new Student(3, 120, 90);
        Student s4 = new Student(4, 150, 95);
        Student s5 = new Student(5, 170, 80);

//        PriorityQueueUsingGenericHeap<Student> pq = new PriorityQueueUsingGenericHeap<>();
//        PriorityQueueUsingGenericHeap<Student> pq = new PriorityQueueUsingGenericHeap<>(new StudentHeightComparator());
//        PriorityQueueUsingGenericHeap<Student> pq = new PriorityQueueUsingGenericHeap<>(new StudentWeightComparator());
        PriorityQueueUsingGenericHeap<Student> pq = new PriorityQueueUsingGenericHeap<>(new StudentHeightComparator());         //compare() logic reversed
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);
        pq.add(s5);

        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
*/

//        ---------------------------------------GENERIC TREE------------------------------------------------------------------------------


//        Node root = TreeConstructor1.buildGenericTree();

//        DisplayTree2.displayTree(root);

//        LevelOrderTraversalLinewise8.levelOrderTraversalLinewise(root);

//        LevelOrderLinewiseZigZag9.levelOrderLinewiseZigZag(root);

//        LevelOrderLinewiseDelimiter10.levelOrderLinewiseDelimiter(root);

//        LevelOrderLinewiseCount11.levelOrderLinewiseCount(root);

        /*LevelOrderLinewisePair12.levelOrderLinewisePair(root);
        System.out.println();
        Node mirrorRoot = MirrorOfGenericTree13.mirror(root);
        LevelOrderLinewisePair12.levelOrderLinewisePair(mirrorRoot);*/

        /*Node leafRemoved = RemoveLeafs14.removeLeaf(root);
        LevelOrderLinewisePair12.levelOrderLinewisePair(leafRemoved);*/
/*
        Node linearizedRoot = LinearizeGenericTree14.linearizeGenericTree(root);
        LevelOrderLinewisePair12.levelOrderLinewisePair(linearizedRoot);*/

/*
        boolean isPresent = FindElementInTree15.findElement(root, 500);
        System.out.println(isPresent);
*/

/*
        ArrayList<Integer> nodeToRootPath = NodeToRootPath16.nodeToRootPath(root, 110);
        System.out.println(nodeToRootPath);

        int lowestCommonAncestor = LowestCommonAncestor17.lowestCommonAncestor(root, 70, 110);
        System.out.println(lowestCommonAncestor);
*/
/*
        int distance = DistanceBetweenNodes18.distanceBetweenNodes(root, 70, 110);
        System.out.println(distance);*/
/*
        MultiSolverSizeHeightMinMax.multiSolver(root, 0);
        MultiSolverSizeHeightMinMax.displayMultiSolver();*/

        /*PredecessorSuccessor.findPredecessorAndSuccessor(root, 90);
        PredecessorSuccessor.displayPredecessorAndSuccessor();*/

        /*CeilAndFloor.findCeilAndFloor(root, 125);
        CeilAndFloor.displayCeilAndFloor();*/

        /*int kthLargest = KthLargestAndSmallestElement25.findKthLargest(root, 3);
        System.out.println("kthLargest: " + kthLargest);

        int kthSmallest = KthLargestAndSmallestElement25.findKthSmallest(root, 4);
        System.out.println("kthSmallest: " + kthSmallest);*/

        /*NodeWithMaxSubtreeSum26.findMaximumSubtreeSum(root);
        NodeWithMaxSubtreeSum26.displayNodeWithMaxSubtree();*/

        /*DiameterOfGenericTree27.findDiameterOfGenericTree(root);
        DiameterOfGenericTree27.displayDiameter();*/

//        IterativePreorderPostorder28.printPreorderPostorder(root);

//        PrintPreorderPostorder.print(root);



// ---------------------------------------------------------------------WIPRO HSBC INTERVIEW----------------------------------------------------------------------------------------------------------

        /*List<String> stationeryList = new ArrayList<>(Arrays.asList("Pen", "Eraser", "Note book", "Pen", "Pencil", "Stapler"));
        long c = stationeryList.stream().filter(s -> s.equals("Pen")).count();
        System.out.println(c);

//        List< String> stationeryListNew = new ArrayList<>(stationeryList);
        stationeryList.add("box");

        System.out.println(stationeryList);*/

        /*
        //static method will be called and execute with static class null reference

        Main m = null;
        m.m1();*/

// ---------------------------------------------------------------------JAVA 8 SYNTAX----------------------------------------------------------------------------------------------------------

        /**
         * Separate odd and even numbers in a list of integers.
         *
         * Given a list of integers, write a Java 8 program to separate
         * the odd and even numbers into two separate lists.
         */

//        Java_8_Syntax.separationOfEvenOddNumberInMap();
//        Java_8_Syntax.separationOfEvenOddNumberInList();


        /**
         * Remove duplicate elements from a list using Java 8 streams
         *
         * Write a Java 8 program to remove duplicate elements from a list
         * using the stream API and lambda expressions.
         */

//        Java_8_Syntax.removeDuplicateFromList();

        /**
         * Find the frequency of each character in a string using Java 8 streams
         *
         * Write a Java 8 program to find the frequency of each character in
         * a given string using the stream API and collectors.
         */
//        Java_8_Syntax.characterFrequency();

        /**
         * Find the frequency of each element in an array or a list
         *
         * Write a Java 8 program to find the frequency of
         * each element in an array or a list using streams and collectors.
         */

//        Java_8_Syntax.wordFrequency();


        /**
         * Sort a given list of decimals in reverse order
         *
         * Write a Java 8 program to sort a given list of decimal numbers in reverse order.
         */

//        Java_8_Syntax.reverseSortedList();

        /**
         * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
         *
         * Given a list of strings, write a Java 8 program to join the strings
         * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
         */

//        Java_8_Syntax.joinListOfStrings();


        /**
         * Print the numbers from a given list of integers that are multiples of 5
         *
         * Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
         */

//        Java_8_Syntax.multipleOf5();

        /**
         * Find the maximum and minimum of a list of integers
         * Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.
         */

//        Java_8_Syntax.minMaxFromList();


        /**
         * Merge two unsorted arrays into a single sorted array using Java 8 streams
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array using the stream API.
         */
//        Java_8_Syntax.mergeUnsortedArrayIntoSorted();

        /**
         * Merge two unsorted arrays into a single sorted array without duplicates
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array without duplicates.
         */
//        Java_8_Syntax.mergeUnsortedArrayIntoSortedWithoutDuplicate();


        /**
         * Get the three maximum and three minimum numbers from a given list of integers
         *
         * Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.
         */

//        Java_8_Syntax.min3max3();

        /**
         * Check if two strings are anagrams or not using Java 8 streams
         * Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
         */

//        Java_8_Syntax.isAnagram();
//        Java_8_Syntax.isAnagram2();


        /**
         * Find the sum of all digits of a number in Java 8
         *
         * Write a Java 8 program to find the sum of all digits of a given number.
         *
         */
//        Java_8_Syntax.sumOf();


        /**
         * Find the second-largest number in an integer array
         *
         * Write a Java 8 program to find the second-largest number in an integer array.
         */
//        Java_8_Syntax.secondLargestNumberFromList();

        /**
         * Sort a list of strings according to the increasing order of their length
         *
         * Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
         */
//        Java_8_Syntax.sortByLengthOfList();































//        findMissingNumber();

        /*int index = SearchInRotatedArray_LC_33.find(new int[] {4, 5, 6, 7, 8, 9, 10, 1, 2}, 10);
        System.out.println(index);*/
/*

        int index = MinimumInSortedRotatedArray_LC_153.findMin(new int[] {4, 5, 6, 7, 8, 9, 10, 1, 2});
        System.out.println(index);
*/
/*
        int noOfPlatform = MinimumNumberOfPlatform.findPlatform();
        System.out.println(noOfPlatform);*/

        /*int sum = MaximumSubArray_LC_53.printSubArrayWithMaxSum(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(sum);*/

        TwoSumII_LC_167.twoSum(new int[] {5,25,75}, 100);
    }

    public static void findMissingNumber() {
        int[] arr = new int[] {1, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] res = new int[] {1, 3, 4, 5, 6, 7, 8, 9, 10, 2};

        for (int i = 0; i <= res.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (res[i] == arr[j]) {
                    res[i] = -1;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1) {
                System.out.println(res[i]);
            }
        }

    }



}
