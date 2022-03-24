package com.kt.ds.learning.arrays.twopointers;

/**
 * Problem Statement - https://leetcode.com/problems/jump-game
 *
 * */

public class JumpGame1 {
    public boolean canJump(int[] nums) {

        /***Starting from second last position
         we need minimum one step to reach last.
         Therefore initialize the gap variable to 1
         if this current possible jump is equal or greater
         than gap we can safely say
         we can reach to last position from curr and keep the gap variable as 1
         now if not the case then increase the gap by 1
         meaning from third last step we would atleast need two step if it is
         not possible to reach from second last step.


         */
        int len = nums.length;
        if(len<2)
            return true;
        int gap = 1;
        boolean possible = true;
        for(int i = len-2;i>=1;i--){
            if(nums[i]<gap) {
                gap++;
            }else{
                gap = 1;
            }
        }
        return nums[0]>=gap;
    }
}
