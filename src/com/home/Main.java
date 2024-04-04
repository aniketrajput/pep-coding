package com.home;

import com.home.arrays_and_string_level2.MajorityElementGeneral_K;
import com.home.arrays_and_string_level2.MajorityElement_1;
import com.home.arrays_and_string_level2.NextGreaterElement_III_LC_556;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

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


    }
}
