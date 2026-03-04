
/*
* @lc app=leetcode id=322 lang=java
*
* [322] Coin Change
*/
import java.util.Arrays;

// @lc code=start
class Solution {
    int[][] dp = new int[13][10001];

    public int coinChange(int[] coins, int amount) {
        int res = help(coins, 0, amount);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    private int help(int[] a, int idx, int amount) {
        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = (j == 0) ? 0 : Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (a[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - a[i - 1]]);
                }
            }
        }
        return dp[a.length][amount];
    }
}
// @lc code=end
