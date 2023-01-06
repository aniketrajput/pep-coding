package com.home.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintIfPrime {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printIfNumberIsPrime(int t) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            numbers.add(scanner.nextInt());
        }

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            int flag = 0;

            for (int j = 2; j <= num/2; j++) {
                if(num % j == 0) {
                    System.out.println("Not Prime");
                    flag = 1;
                    break;
                }
            }

            if (flag == 0)
                System.out.println("Prime");
        }
    }
}
