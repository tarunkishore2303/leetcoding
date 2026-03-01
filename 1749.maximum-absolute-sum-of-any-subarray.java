/*
 * @lc app=leetcode id=1749 lang=java
 *
 * [1749] Maximum Absolute Sum of Any Subarray
 */

// @lc code=start
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0, curr = 0, min = 0;
        for(int i=0;i<nums.length;i++){
            curr += nums[i];
            max = Math.max(max,curr);
            min = Math.min(min,curr);
        }
        return max - min;
    }
}
// @lc code=end

