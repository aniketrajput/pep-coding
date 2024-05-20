package com.home.hashmap_heaps_level_1.genericpriorityqueue;

public class Student implements Comparable<Student>{
    int rollNo;
    int height;
    int weight;

    public Student(int rollNo, int height, int weight) {
        this.rollNo = rollNo;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student s) {
        return this.rollNo - s.rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

