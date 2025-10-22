/*
 * @lc app=leetcode id=2554 lang=java
 *
 * [2554] Maximum Number of Integers to Choose From a Range I
 */

// @lc code=start
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] nums = new int[10001];
        int ans = 0;
        for (int i = 0; i < banned.length; i++) {
            nums[banned[i]] = 1;
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if(nums[i]==1) continue;
            sum += i;
            if(sum > maxSum){
                break;
            }
            ans++;
        }
        return ans;
    }
}
// @lc code=end
