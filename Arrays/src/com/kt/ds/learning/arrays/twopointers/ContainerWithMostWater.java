package com.kt.ds.learning.arrays.twopointers;

/***
 * https://leetcode.com/problems/container-with-most-water
 * Problem Statement:
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Solution:
 *
 * Brute Force - Check all the pairs and find the max area
 *
 * Optimal Solution - The area is defined as the length * breadth;
 *
 * Start with two pointers one at left end, other at right end - that is maximum breadth.
 * now we have two heights H_left and H_right. To maximum the area the pointer we should try to increase the height
 * that is limited by the height of smaller end. Therefore to increase the area we should move the pointer standing at smaller height.
 *
 *
 * */


public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int start = height[0];
        int end = height.length - 1;
        int max = 0;
        while(start<end) {
            max = Math.max(max, (end-start)*Math.min(height[end], height[max]));
            if(height[end]<height[start])
                end--;
            else
                start++;
        }
        return max;

    }

}


