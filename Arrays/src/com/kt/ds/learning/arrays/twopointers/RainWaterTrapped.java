package com.kt.ds.learning.arrays.twopointers;

/***
 * https://leetcode.com/problems/trapping-rain-water/
 * Problem statement at above link
 *
 * Solution Approach
 * Find the water that can be trapped at each block
 * */


public class RainWaterTrapped {
    public int trap(int[] height) {
        int len = height.length;
        int[] largest_left = new int[len];
        int[] largest_right = new int[len];
        largest_left[0] = -1;
        int largest = height[0];
        for(int i = 1;i<len;i++) {
            largest = Math.max(largest, height[i]);
            largest_left[i] = largest;
        }
        largest = height[len-1];
        for(int i = len-2;i>=0;i--){
            largest = Math.max(largest, height[i]);
            largest_right[i] = largest;
        }
        int sum = 0;
        for(int i = 1;i<len-1;i++){
            sum += Math.min(largest_right[i], largest_left[i]) - height[i];
        }
        return sum;
    }
}
