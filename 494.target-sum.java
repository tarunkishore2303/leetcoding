/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for (int num : nums)
            total += num;

        if (Math.abs(target) > total)
            return 0;

        int size = 2 * total + 1;

        int[][] dp = new int[n + 1][size];

        dp[n][total] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i + 1][j - nums[i]];
                }
                if (j + nums[i] < size) {
                    dp[i][j] += dp[i + 1][j + nums[i]];
                }
            }
        }
        return dp[0][total + target];
    }
}
// @lc code=end
