/*
 * @lc app=leetcode id=2321 lang=java
 *
 * [2321] Maximum Score Of Spliced Array
 */

// @lc code=start
class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
       return Math.max(solve(nums1, nums2),solve(nums2, nums1));
    }

    private int solve(int[] nums1, int[] nums2){
        int total = 0;

        int maxGain = 0, currSum = 0;

        for(int i=0;i<nums1.length;i++){
            int gain = nums2[i] - nums1[i];

            total += nums1[i];

            currSum = Math.max(gain, gain + currSum);

            maxGain = Math.max(maxGain,currSum);
        }
        return total + maxGain;
    }
}
// @lc code=end

