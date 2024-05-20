package com.home.arrays_and_string_level_2;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfPlatform {

    public static int findPlatform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Enter n arrival times: ");
        int[] arrivals = new int[n];
        for (int i = 0; i < n; i++) {
            arrivals[i] = scanner.nextInt();
        }

        System.out.println("Enter n departure times: ");
        int[] departures = new int[n];
        for (int i = 0; i < n; i++) {
            departures[i] = scanner.nextInt();
        }

//-----------------------------------------------------------------------

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int maxTrainsOnPlatform = 0;            //number of trains waiting on platform currently
        int noOfPlatforms = 0;                  //minimum no of platforms required
        int i = 0;                              //pointer to arrivals
        int j = 0;                              //pointer to departure


        while (i < n && j < n) {                                     //iterate till we have arrival time or departure time
            if (arrivals[i] <= departures[j]) {             // = because if arrival and departure of any train is same then also we need to give different platform to it.
                maxTrainsOnPlatform++;                      //give new platform to this train
                i++;
            }
            else {
                maxTrainsOnPlatform--;                      //free the platform
                j++;
            }
            noOfPlatforms = Math.max(noOfPlatforms, maxTrainsOnPlatform);       //maintain the max no of platform which was required
        }

        return noOfPlatforms;
    }

}
