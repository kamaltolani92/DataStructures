package com.kt.ds.learning.stacks;

import java.util.Stack;

/***
 *  Given an array of integers,
 *  find the nearest greater number for every element such that the greater element is on right side.
 *  put -1 is dne
 *  Input:  arr[] = {1, 6, 4, 10, 2, 5}
 *  Output:         {6, 10, 10, -1, 5, -1}
 *
 * */


public class NearestGreaterElement {
    public int[] nearestGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            int curr = nums[i];
            while(!stack.isEmpty() && stack.peek()<=curr)
                stack.pop();
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(curr);
        }
        return res;
    }

    public static void main(String[] args) {
        NearestGreaterElement nGE = new NearestGreaterElement();
        int nums[] = {1, 6, 4, 10, 2, 5};
        int res[] = nGE.nearestGreaterElement(nums);
        for (int element : res) {
            System.out.print(element + ", ");
        }
    }
}
