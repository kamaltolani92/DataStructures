package com.kt.ds.learning.stacks;

import java.util.Arrays;
import java.util.Stack;

/***
 * https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 *
 * Given an array of integers,
 * find the nearest smaller number for every element such that the smaller element is on left side.
 * Input:  arr[] = {1, 6, 4, 10, 2, 5}
 * Output:         {_, 1, 1,  4, 1, 2}
 *
 * Approach
 * We can use a stack to maintain only the smaller elements - relative to current element
 *
 * Start processing from left to right, for each element we can pop out all the elements greater than the current element
 * from the stack
 * because for any element to the right the current element can act as the nearest smaller element and makes all the elements
 * greater than current element in the stack poor choices
 *
 * Take the following example
 *
 * arr[] = {1, 6, 4, 10, 2, 5}
 *
 * Initially
 *  Stack - Empty
 *
 * Iteration #1
 *  Processing - 1
 *  output - [_] - there will be no smaller element left of the first element
 *  pushing current element to stack as it could possibily
 *  act as smaller element for one of the elements to the right
 *  Stack - 1
 *
 * Iteration #2
 *  Processing - 6
 *  output - [_, 1] - the top of the stack has 1 that is smaller than current element therefore 1 is already to the output
 * pushing current element to stack as it could possibily
 *   act as smaller element for one of the elements to the right
 *   Stack - 1, 6
 *
 * Iteration #3
 *  Processing - 4
 *  Here 4 can act as nearest smaller element for all elements greater than 4 to the right
 *  x>=4
 *  and 6 can act as nearest smaller for all elements greater than 6 to the right
 *  x>=6
 *  First equation covers all the cases covered by second equation therefore we can remove 6 from the stack
 *  Stack - 1
 *  Output - [_,1,1]
 *  Push 4
 *  Stack - 1, 4
 *
 *  and so on....
 *
 *
 * */


public class NearestSmallerElement {

    public int[] nearestSmallerElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums.length;i++) {
            int curr = nums[i];
            while(!stack.isEmpty() && stack.peek()>=curr)
                stack.pop();
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(curr);
        }
        return res;

    }

    public static void main(String[] args) {
        NearestSmallerElement nearestSmallerElement = new NearestSmallerElement();
        int nums[] = {4, 5, 2, 10, 8};
        int res[] = nearestSmallerElement.nearestSmallerElement(nums);
        for(int element: res) {
            System.out.print(element + ", ");
        }
    }


}
