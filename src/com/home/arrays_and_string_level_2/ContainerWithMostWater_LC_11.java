package com.home.arrays_and_string_level_2;

/*
Check notebook for analysis
*/

public class ContainerWithMostWater_LC_11 {

    public static int maxArea(int[] height) {
        int water = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);

            water = Math.max(water, w * h);

            if (height[i] < height[j]) {
                i++;
            }
            else {      //if both are heights are same then also j-- will happen
                j--;
            }
        }

        return water;
    }
}
