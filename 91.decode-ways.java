/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[n] = 1;
        for(int i = n-1; i>=0;i--){
            if(s.charAt(i)!='0'){
                dp[i] = dp[i+1];
                if(i<n-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

