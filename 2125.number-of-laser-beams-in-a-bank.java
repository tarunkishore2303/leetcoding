/*
 * @lc app=leetcode id=2125 lang=java
 *
 * [2125] Number of Laser Beams in a Bank
 */

// @lc code=start
class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int ans = 0, prev = 0;
        for(int i=0;i<m;i++){
            String s = bank[i];
            int device = 0;
            for(char c: s.toCharArray()){
                if(c == '1') device++;
            }
            if(device > 0){
                ans += prev * device;
                prev = device;
            }
        }
        return ans;
    }
}
// @lc code=end

