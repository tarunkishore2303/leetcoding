/*
 * @lc app=leetcode id=2958 lang=java
 *
 * [2958] Length of Longest Subarray With at Most K Frequency
 */

// @lc code=start
import java.util.*;
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0 , l = 0, r = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r < nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r]) > k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}
// @lc code=end

