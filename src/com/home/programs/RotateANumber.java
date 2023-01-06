package com.home.programs;

import java.util.Scanner;
/*
You are given two numbers n and k. You are required to rotate n, k times to right.
If k is positive rotate to the right i.e. remove rightmost digit and make it leftmost.
Do the reverse for negative value of k.
Also, k can have an absolute value larger than number of digits in n.
Take as input n and k.
Print the rotated number.
Note - Assume that the number of rotations will not cause leading 0's in the result eg. such an input will not be given.
n - 12340056
k - 3
r - 05612340
*/

public class RotateANumber {
    private static final Scanner scanner = new Scanner(System.in);

    public static void rotateANumber () {
        System.out.println("Enter the Number: ");
        int number = scanner.nextInt();
        System.out.println("Enter the Rotation: ");
        int rotation = scanner.nextInt();
        int tempNumber = number;
        int count = 0;

        while (tempNumber != 0) {
            tempNumber = tempNumber / 10;
            count++;
        }

        // if count is 5 and rotation is 5 then result will be same number, same way for rotation 10, 15, etc. same number will be there.
        rotation = rotation % count;

        // convert negative rotation into positive rotations. If count is 5 and rotation is -1, then left rotating by 1 is same as right rotating by 4.
        if (rotation < 0) {
            rotation = rotation + count;
        }

        int multiplier = 1;
        int divisor = 1;

        for (int i = 0; i < count; i++) {
            if (i < rotation) {
                divisor = divisor * 10;
            } else {
                multiplier = multiplier * 10;
            }
        }

        int remainder = number % divisor;
        int quotient = number / divisor;

        int result = multiplier * remainder + quotient;

        System.out.println("Result: " + result);
    }
}
