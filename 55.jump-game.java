/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, n = nums.length;
        while(i<n){
            if(nums[i] == 0) {
                i++;
                continue;
            }
            i += nums[i];
            if(i==n-1) return true;
        }
        System.out.println(i);
        return false;
    }
}
// @lc code=end

