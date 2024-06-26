package com.home.leetcode_medium;

/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true

        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.

Example 2:
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false

        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:
        1 <= numCourses <= 2000
        0 <= prerequisites.length <= 5000
        prerequisites[i].length == 2
        0 <= ai, bi < numCourses

All the pairs prerequisites[i] are unique.

*/

import java.util.*;

public class Course_Schedule_LC_207 {
    
    static Map<Integer, List<Integer>> preMap = new HashMap<>();
    static Set<Integer> visitedSet = new HashSet<>();
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            List<Integer> neighbours = preMap.get(p[0]);     //get existing list of current course
            neighbours.add(p[1]);                            //add dependent course to list of current course
            preMap.put(p[0], neighbours);                    //update map with new list
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap, visitedSet)) {                //call dfs on each course, if dfs for any course is false, then return false
                return false;
            }
        }
        
        return true;
    }

    private static boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitedSet) {
        if (visitedSet.contains(course))        //base case 1
            return false;                       //this means this course is already visited and now being re-visited, so this is a cycle
        
        if (preMap.get(course).size() == 0)     //base case 2
            return true;                        //this means there is no pre-requisite for this course, and it can be completed

        visitedSet.add(course);                 //add course to visitedSet as we are now visiting this course

        for (int prerequisite : preMap.get(course)) {
            if (!dfs(prerequisite, preMap, visitedSet)) {
                return false;
            }
        }

        visitedSet.remove(course);                    //remove for visitedSet because now we are leaving/completing  the course
        preMap.put(course, new ArrayList<>());        //as this course can be completed, change its pre-requisite list to empty list

        return true;
    }
}



/*

Neetcode video for explanation - https://www.youtube.com/watch?v=EgI5nU9etnU&list=PLot-Xpze53lfOdF3KwpMSFEyfE77zIwiP&index=12&t=774s

DFS -
        n = 5
        prerequisites = [[0,1], [0,2], [1,3], [1,4], [3,4]]

        Initialization -

        visitedSet = []

        preMap =
        courses		preList
         0		   [1, 2]
         1		   [3, 4]
         2		   []
         3		   [4]
         4		   []

------

        visitedSet = [0]

        preMap =

            courses		preList
             0		   [1, 2]
             1		   [3, 4]
             2		   []
             3		   [4]
             4		   []


            visitedSet = [0, 1, 3, 4];  0 -> [1, 2] =>					1 -> 3 -> 4 -> []					//4 returns true to 3
            visitedSet = [0, 1, 3];  	0 -> [1, 2] =>					1 -> 3 -> []						//3 returns true to 1
            visitedSet = [0, 1, 4];  	0 -> [1, 2] =>					1 -> [3[done], 4] -> [] 			//for 1, 3 is done, second iteration for 4 returns true
            visitedSet = [0, 2];  		0 -> [1[done], 2] =>			1 -> [3[done], 4[done]] -> []

            visitedSet = [0, 2];  		0 -> [1[done], 2] =>			2 -> []
            visitedSet = [0];  			0 -> [1[done], 2[done]] -> []

            visitedSet = [];

*/



