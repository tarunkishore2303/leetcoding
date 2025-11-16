/*
 * @lc app=leetcode id=2439 lang=java
 *
 * [2439] Minimize Maximum of Array
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefSum = 0L;
        long ans = 0L;
        for(int i=0;i<nums.length;i++){
            prefSum += nums[i];
            long avg = (prefSum + i)/(i+1);
            ans = Math.max(avg,ans);
        }
        return (int) ans;
    }
}
// @lc code=end
