/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0, d=Integer.MAX_VALUE, start = 0;
        int[] freq = new int[128];
        for(char c: t.toCharArray()) freq[c - 'a']++;
        while(j < m){
            if(freq[s.charAt(j++)-'a']-- > 0){
                n--;
            }
            while(n == 0){
                if(j-i<d){
                    i= start;
                    d = j-i;
                }
                if(freq[s.charAt(i++)]++ == 0){
                    n++;
                }
            }

        }
        return d == Integer.MAX_VALUE ? "" : s.substring(start, d);
    }
}
// @lc code=end

