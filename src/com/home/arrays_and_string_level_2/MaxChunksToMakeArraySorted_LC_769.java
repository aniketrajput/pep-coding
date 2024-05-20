package com.home.arrays_and_string_level_2;

/*
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Example 1:
    Input: arr = [4,3,2,1,0]
    Output: 1
    Explanation:
    Splitting into two or more chunks will not return the required result.
    For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Example 2:
    Input: arr = [1,0,2,3,4]
    Output: 4
    Explanation:
    We can split into two chunks, such as [1, 0], [2, 3, 4].
    However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

Constraints:
    n == arr.length
    1 <= n <= 10
    0 <= arr[i] < n
    All the elements of arr are unique.

Check explanation in notebook....

*/

public class MaxChunksToMakeArraySorted_LC_769 {
    public static int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunkCount = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);            //Suppose element at 0th was 3 so max will become 3, impact is till 3rd index. But suppose on 2nd index we have element 5, then max will update to 5 and impact will become till 5. Chunk will also end on 5 if no larger element than 5 is encountered.

            if (max == i) {     //have we reached till the impact index? If yes, chunk is over. The next element after the impact index will always be greater than max, because as we have  permutation of the integers in the range [0, n - 1] in array
                chunkCount++;
            }
        }

        return chunkCount;
    }

}
