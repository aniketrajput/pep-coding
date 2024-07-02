package com.home.leetcode_medium;

/*

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
        Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000

*/

public class RotateImage_LC_48 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {     //(n + 1) / 2 we do +1 because if n = 5 it will return 2, but we need 3. Without +1 will work fine with n = 4

            for (int j = 0; j < n / 2; j++) {
                //Start 4 way swap

                //temp = bottom left
                int temp = matrix[n - 1 - j][i];

                //bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 -i][n - j - 1];

                //bottom right = top right
                matrix[n - 1 -i][n - j - 1] = matrix[j][n - 1 - i];

                //top right = top left
                matrix[j][n - 1 - i] = matrix[i][j];

                //top left = temp
                matrix[i][j] = temp;
            }
        }

    }
}


/*

Brute Force -
        - We can create a new array and copy row but row at expected positions
        - Problem is we had to create new matrix.

4 ways swapping
        - Do 4 way swap only to the outer ring boxes
        - we will 1st swap the corner 4 boxes
        - then move to next box after corners and do swap for those and so on..
        - Once most outer ring boxes are done, move the next inner ring and perform swapping same way.

Two loops, the outer loop keeps track of rings and inner loop will keep track of each element in the ring we are choosing
Only one temp variable is needed.

*/
