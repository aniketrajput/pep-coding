package com.home.dsa_level_1;

/*

1. You are given n number of bulbs. They are all switched off. A weird fluctuation in voltage hits
the circuit n times.
In the 1st fluctuation all bulbs are toggled.
In the 2nd fluctuation every 2nd bulb is toggled.
In the 3rd fluctuation every 3rd bulb is toggled and so on.
You've to find which bulbs will be switched on after n fluctuations.
2. Take as input a number n representing the number of bulbs.
3. Print all the bulbs that will be on after the nth fluctuation in voltage.

*/

import java.util.Scanner;

public class BenjaminBulbs34 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printOnBulbs() {
        System.out.println("Enter n: ");

        int n = scanner.nextInt();
        int[] bulbs = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (j % i == 0) {
                    if (bulbs[j - 1] == 0)
                        bulbs[j - 1] = 1;
                    else if (bulbs[j - 1] == 1)
                        bulbs[j - 1] = 0;
                }
            }
        }

        System.out.println("On bulbs are: ");

        for (int i = 0; i < n; i++) {
            if (bulbs[i] == 0)
                System.out.println(i + 1 + ", ");
        }
    }

}
