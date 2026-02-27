/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        // Recursive condition -> end when reaching the end of array
       return rob(nums,nums.length - 1);
    }
    private int rob(int[] nums, int n){
        if(n < 0) return 0;
        if(memo[n] >= 0) return memo[n
        memo[n] =  Math.max(rob(nums, n-2)+nums[n],rob(nums,n-1));
        return memo[n];
    }
}
// @lc code=end

