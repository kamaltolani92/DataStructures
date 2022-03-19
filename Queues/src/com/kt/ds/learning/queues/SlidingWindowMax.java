package com.kt.ds.learning.queues;

import java.util.LinkedList;

public class SlidingWindowMax {


    /***
     * Problem Statement
     * You are given an array of integers nums, there is a sliding window of size k
     * which is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     *
     * Return the max sliding window.
     * <a href="URL#https://leetcode.com/problems/sliding-window-maximum/">Question Link</a>
     *
     * The idea here is to maintain an decreasing dequeue (Double ended queue)
     * This dequeue at any instance tells you what is the next eligible
     * candidate for the max when an element is moved out of the window
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *
     * Iteration #1 - processing 1
     * queue - 1
     * Iteration #2 - processing 3
     * queue - 3
     * 1 can be removed from the queue because with 3 that will always exit after 1.
     * 3 will always be max with any window containing both 1 and 3
     *
     * Iteration #3 - processing -1
     * queue - 3 , -1
     * -1 should be added to queue to maintain a decreasing queue.
     * When 3 will be removed -1 will be the next max element . .
     * Output will always be the first element of the queue that is the most eligible element
     * output - [3]
     * Iteration #4 -processing -3
     * queue - 3, -1, -3
     * output - [3, 3]
     * Iteration #5 processing 5
     * First 3 is out of window so remove 3 from the queue. Next with 5 in picture we can remove all the elements smaller than 5 to maintain a decreasing sequece
     * queue - 5
     * output - [3, 3, 5]
     * Iteration #6 processing 3
     * queue - 5 , 3
     * output - [3, 3, 5, 5]
     * Iteration #7 processing 6
     * queue - 6
     * output - [3, 3, 5, 5, 6]
     * Iteration #8 processing 7
     * queue - 7
     * output - [3, 3, 5, 5, 6, 7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int output[] = new int[len - k + 1];
        for(int i = 0;i<k;i++){
            int curr = nums[i];
            while(!queue.isEmpty() && queue.peekLast()<curr)
                queue.removeLast();
            queue.add(curr);
        }
        //First output
        output[0] = queue.peek();
        for(int i = k;i<len;i++) {
            //Window. changed remove the element out of window from the dequeue if present
            int elementToBeRemoved = nums[i-k];
            if(queue.peek() == elementToBeRemoved) {
                queue.remove();
            }
            int curr = nums[i];
            while(!queue.isEmpty() && queue.peekLast()<curr)
                queue.removeLast();
            queue.add(curr);
            output[i-k+1] = queue.peek();
        }
        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(slidingWindowMax.maxSlidingWindow(input, 3));
        
    }

}
