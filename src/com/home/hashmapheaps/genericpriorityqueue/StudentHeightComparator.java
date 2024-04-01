package com.home.hashmapheaps.genericpriorityqueue;

import java.util.Comparator;

public class StudentHeightComparator implements Comparator<Student> {              //For Student class we already have Comparable interface which compares on rollNo, if we want comparison on other properties of Student as well, then we can use Comparator.

    @Override
    public int compare(Student o1, Student o2) {
        return o2.height - o1.height;
    }
}
