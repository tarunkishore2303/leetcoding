/*
 * @lc app=leetcode id=2962 lang=java
 *
 * [2962] Count Subarrays Where Max Element Appears at Least K Times
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElem = Integer.MIN_VALUE;
        long ans = 0;
        for (int num : nums) {
            maxElem = Math.max(maxElem, num);
        }
        int l = 0, r = 0, count = 0;
        while (r < nums.length) {
            if (nums[r] == maxElem)
                count++;
            while (count >= k) {
                if (nums[l] == maxElem)
                    count--;
                l++;
                ans += nums.length - r;
            }  
            r++;
        }
        return ans;

    }
}
// @lc code=end
