package com.home.leetcode_easy_collection;
/*

Write a function that takes the binary representation of a positive integer and returns the number of set bits it has (also known as the Hamming weight).

Example 1:
        Input: n = 11
        Output: 3
        Explanation:
        The input binary string 1011 has a total of three set bits.

Example 2:
        Input: n = 128
        Output: 1
        Explanation:
        The input binary string 10000000 has a total of one set bit.

Example 3:
        Input: n = 2147483645
        Output: 30
        Explanation:
        The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

Constraints:
        1 <= n <= 231 - 1

*/


public class NumberOf1Bits_LC_191 {

    public int hammingWeight1(int n) {
        int count = 0;

        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;

        while (n != 0) {
            count = count + n % 2;
            n = n/2;
        }

        return count;
    }

    public int hammingWeight4(int n) {
        return Integer.bitCount(n);
    }
}

/*

https://www.youtube.com/watch?v=YOyajw-L0pc

Some Facts -
    1. How to find ith bit of a number?

        (num >> i) & 1

        Example -
            i = 3
            input = 0 1 0 1 0 		(indexing as follows - 4 3 2 1 0)

            After right shift = 0 0 0 0 1

            Perform & operation with 1 =>

            0 0 0 0 1
            &	0 0 0 0 1
            ----------
            0 0 0 0 1

            Ans = 1

    2. How to unset the right-most set bit of an integer?

            n = n & (n-1)

        Example -

            Input - 1 1 0 0 1 0    (50)		= we want to make right-most 1 to 0 => 1 1 0 0 0 0

            n = 50
            n - 1 = 49 => 1 1 0 0 0 1

            1 1 0 0 1 0
            &  1 1 0 0 0 1
            ----------------
            1 1 0 0 0 0			=> answer


Approach 1 - Using fact 1

        n = 0000 ..... 1011		(32 bits)	(indexing  - 31 30 29 28 ...... 3 2 1 0)

        for(i = 31; i >= 0; i++)
        {
            if((n >> i) & 1 == 1) {				//check if ith bit is 1 using above fact
                count++;
            }
        }

        Time - O(32) - O(1)

Approach 2 - Using fact 2

        n = 0 1 1 0 1 	(13)

        We will keep on making the rightmost set bit (1) to 0, and count in each iteration. When all bits becomes 0 stop and we have got the count of 1s.

        n = 0 1 1 0 1 					=> 13 != 0
        n = n & (n - 1) = 0 1 1 0 0 	=> 12 != 0		count++
        n = n & (n - 1) = 0 1 0 0 0 	=> 8 != 0		count++
        n = n & (n - 1) = 0 0 0 0 0		=> 0 == 0		count++

        as n ==0 stop iterating, count = 3

        while(n > 0) {
            n = n & (n - 1);
            count++;
        }

        Time - Loop iteration will be equal to number of 1 bits present in number, so O(K) where K is number of 1 bits present

Approach 3 -

        To find binary of a number we use following steps -

        number = 30

        2 | 30 | 0						divisor| | remainder
        2 | 15 | 1
        2 | 7  | 1
        2 | 3  | 1
        2 | 1  | 1
        | 0  |

        Binary - 0 1 1 1 1 0			- We start from last 0 followed by remainders from down to up

        while(n != 0) {
            count = count + (n % 2);		//if binary bit or remainder is 1, then it will be added
            n = n/2
        }

        Time - everytime we are breaking number by / 2, so log2(n)	- Note 2 is in base. When we break any number by 2 then it will be always log base 2

Approach 4 -

        Java API - Integer.bitCount(n)		=> this will return the number of set bits

*/
