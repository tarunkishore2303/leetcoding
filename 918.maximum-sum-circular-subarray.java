/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int maxSum = nums[0], currMax = nums[0];
        int minSum = nums[0], currMin = nums[0];


        for(int i=1;i<nums.length;i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(currMax,maxSum);

            currMin = Math.min(nums[i],currMin + nums[i]);
            minSum = Math.min(currMin,minSum);

            totalSum += nums[i];
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
// @lc code=end

