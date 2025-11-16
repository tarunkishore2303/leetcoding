/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int l = 0, r = 0 , n = s.length(), ans= 0;
        int[] freq = new int[128];
        while(r<n){
            freq[s.charAt(r)-'a']++;
            if(freq[s.charAt(r)-'a'] >= k){
                ans = Math.max(ans,r-l+1);
            }
        }
        return ans;
    }
}
// @lc code=end

