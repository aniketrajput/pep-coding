package com.home.leetcode_easy;

/*

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:
        - Element at grid[i][j] moves to grid[i][j + 1].
        - Element at grid[i][n - 1] moves to grid[i + 1][0].
        - Element at grid[m - 1][n - 1] moves to grid[0][0].
        - Return the 2D grid after applying shift operation k times.

Example 1:
        Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
        Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
        Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
        Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:
        Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
        Output: [[1,2,3],[4,5,6],[7,8,9]]

Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m <= 50
        1 <= n <= 50
        -1000 <= grid[i][j] <= 1000
        0 <= k <= 100

*/

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid_LC_1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k = k % total;              //if total is 9 and k is 10, then performing shifting with k = 10 and k = 1 will give same result. Thus, no need to do 10 shifting we can get result with just 1 shifting, so k % total will take care of this.

        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int flatIndex = findShiftedFlatIndex(i, j, n, k, total);
                sublist.add( grid[flatIndex / n][flatIndex % n]);
            }

            result.add(sublist);
        }

        return result;
    }

    private int findShiftedFlatIndex(int i, int j, int n, int k, int total) {
        return (i * n + j + total - k) % total;
    }
}


/*

https://www.youtube.com/watch?v=7-ytX01i9vA


We are given 2D matrix, and we want to identify this 2D matrix in 1D matrix format then following is formula -

        int FlatIndex = (i * col + j) % total;                      //without shifting, FlatIndex for 1D array

        int FlatIndex = (i * col + j + total - k) % total           //with shifting, FlatIndex for 1D array

And following is reversal formula for converting 1D matrix FlatIndex back to 2D matrix [i, j] indexes -

        Grid[FlatIndex / col, FlatIndex % col]

Example, following 2D array can be converted to flat 1D array -

        1 2 3
        4 5 6	=>	1 2 3 4 5 6 7 8 9
        7 8 9

Idea to solve this problem is to find FlatIndex for 1D array considering the shifting, then convert FlatIndex into 2D grid indexes [i, j] and use that value in result 2D array

Time complexity - O(n * m)
Space complexity - O(n * m)

*/


