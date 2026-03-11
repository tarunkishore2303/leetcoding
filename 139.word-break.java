/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String str : wordDict) {
                int start = i - str.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end
