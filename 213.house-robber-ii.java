/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2),rob(nums,1,nums.length - 1));
    }
    private int rob(int[] nums, int l, int r){
        int prev = 0, curr = 0;
        for(int i=l;i<=r;i++){
            int temp = Math.max(curr,prev+nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
// @lc code=end

